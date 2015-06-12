import java.io.*;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.animation.PauseTransition;

import javax.swing.*;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 *
 * @author sankhe
 */

public class Controller implements  ActionListener {
	// List the models and views that the controller interacts with
	//private Vehicle model; // object being animated
	private ArrayList<Cake> model; // object being animated
	private View view;   
	private Timer timer; // create a swing timer to run periodically
	private static int cupCakeCount = 0;
	private int studentInput = 0;
	private Random rand;
	private static int randomNumMaximum = 5;
	private static int questionNumber = 0;
	private static int studentScore = 0;
	StudentModel studentModel;

	/*
	 *  Please change the path to the folder where music is stored.
	 *       
	 */

	//private String pathToMusic = "C:/Users/sankhe/Desktop/JAVA/CD_contents/Contents/JavaBook/audio/";
	  File file=new File(".");
	  private String path = file.getAbsolutePath().replace(".", "").trim() + "audioAndimages/";
	  private String pathToMusic = path.replace("\\", "/");
	  

	/*
	 * 				  ^  ^  ^  ^  ^  ^  ^  ^  ^
	 *                |  |  |  |  |  |  |  |  | 
	 */


	/**
	 * @return the studentScore
	 */
	public static int getStudentScore() {
		return  studentScore;
	}

	/**
	 * @return the question
	 */
	public static int getQuestionNumber() {
		return questionNumber;
	}

	/**
	 * @return the randomNumMaximum
	 */
	public static int getRandomNumMaximum() {
		return randomNumMaximum;
	}

	/**
	 * @param randomNumMaximum the randomNumMaximum to set
	 */
	public static void setRandomNumMaximum(int randomNumMaximum) {
		Controller.randomNumMaximum = randomNumMaximum;
	}

	/**
	 * @return the cupCakeCount
	 */
	public static int getCupCakeCount() {
		return cupCakeCount;
	}

	/**
	 * @param cupCakeCount the cupCakeCount to set
	 */
	public static void setCupCakeCount(int cupCakeCount) {
		Controller.cupCakeCount = cupCakeCount;
	}

	/* This method will generate question according to random input */
	public void generateQuestion() {
		questionNumber = questionNumber + 1;
		studentInput = rand.nextInt(getRandomNumMaximum()) + 1;
		String str = "Can you give Teddy " +studentInput+" cakes?";
		view.getjLabel1().setText(str);
		playQuestionAudio();
	}

	public void playQuestionAudio() {

		String str = pathToMusic+studentInput+ ".wav";
		playMusic(str);
	}

	public void playMusic(String str) {
		InputStream in;
		try {
			in = new FileInputStream(str);
			AudioStream audios = new AudioStream(in);
			AudioPlayer.player.start(audios);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error has occurred while reading image file. Check that file exists and is in the correct directory.");
			System.exit(1);
			//e.printStackTrace();
		}
	}

	// public Controller(Vehicle m, View v) {
	public Controller(ArrayList<Cake> m, View v) {
		//System.out.println(pathToMusic);
		model = m;
		view = v;
		timer = new Timer(30, this);

		studentModel = MainFrame.getStudentModel();

		rand = new Random();
		generateQuestion();

		// add listeners to view
		view.addStartListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cupCakeCount = 0;
				doEnterPressed();
			}
		});

		// add listeners to view
		view.addStopListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when the stop button is pressed timer stops running
				//String str = pathToMusic+"quitButtonMessage.wav";
				//playMusic(str);
				//displayConfirmGameEndMessage();
				int returnValue = JOptionPane.showConfirmDialog(view.getWindow(), "Do you want to continue? Click YES to continue or NO "
						+ "to quit the game",  "Confirm Dialog",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(returnValue == JOptionPane.YES_OPTION) { 
					MainFrame.layCard.show(MainFrame.getTopPanel(), "2");
					AudioPlayer.player.stop();
					resetGame();
				}
			}
		});	

		view.addKeyboardListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Key with char " +e.getKeyChar() +" typed");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
				// System.out.println("Key with keycode " +e.getKeyCode() +" released");
			}

			
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(this);
				//System.out.println("Key with keycode " +e.getKeyCode()+" pressed");
				
				if(e.getKeyCode() == 32 ) {
					timer.stop();
					int n = getCupCakeCount();
					//System.out.println("before" +n);
					n = n + 1;
					setCupCakeCount(n);
					//System.out.println("after" +n);
					timer.start();
				}
				if(e.getKeyCode() == 10 ) {
					doEnterPressed();
				}
				
				if(e.getKeyCode() == 37) {
					
					MainFrame.layCard.show(MainFrame.getTopPanel(), "7");
					String str11 = pathToMusic+"restartGame.wav";
					StartGame.getObjectofClass().setFocusable(true);
					StartGame.getObjectofClass().requestFocusInWindow();
					playMusic(str11);
					
					resetGame();

					questionNumber = questionNumber + 1;
					studentInput = 3;
					String str = "Can you give Teddy " +studentInput+" cakes?";
					view.getjLabel1().setText(str);
					view.getjPanel1().repaint();
				}
				
				if(e.getKeyCode() == 39) {
					MainFrame.layCard.show(MainFrame.getTopPanel(), "2");
					AudioPlayer.player.stop();
					resetGame();
				}
			}
		});
	}

	/* This method reset all values to restart the game */
	public void resetGame() {
		studentInput = 0;
		studentScore = 0;
		questionNumber = 0;
		timer.stop();
		setCupCakeCount(0);
		Cupcake.start();
		//GamePlayerLogin.currentPlayer = null;
		
	}

	/* This method displays the message when game is over */
	public void gameOverMessageDisplay() {
		String str1 = pathToMusic+ "gameOver.wav";
		playMusic(str1);
		String str = "Game Over !! \nYour Score is "+ studentScore +
				"\n Play again? Click YES(Enter) to start the game or NO(Space bar) to exit";
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playScoreMusic();
		updateScore();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temp = pathToMusic+"wannaContinueMessage.wav";
		playMusic(temp);
		//int ret = JOptionPane.showConfirmDialog(view.getWindow(), str , "Confirm Dialog",JOptionPane.PLAIN_MESSAGE);
		/*int returnValue = JOptionPane.showConfirmDialog(view.getWindow(), str , "Confirm Dialog",JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
		resetGame();*/
		
		/*if(returnValue == JOptionPane.YES_OPTION) {
			MainFrame.layCard.show(MainFrame.getTopPanel(), "7");
			String str11 = "C:/Users/sankhe/Desktop/JAVA/CD_contents/Contents/JavaBook/audio/startGame.wav";
			playMusic(str11);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			MainFrame.layCard.show(MainFrame.getTopPanel(), "2");
			AudioPlayer.player.stop();
		}*/
		//studentScore = 0;
		//timer.stop();
	}

	/*public void gameOverForQuitButton() {
		String str1 = pathToMusic+ "gameOver.wav";
		playMusic(str1);
	} */

	public void playScoreMusic() {
		String str = pathToMusic+studentScore+ "_score.wav";
		playMusic(str);
	}

	public int updateScore() {
		Student s1 = studentModel.loginPlayer(GamePlayerLogin.currentPlayer.getFirst_name(), GamePlayerLogin.currentPlayer.getLast_name());
		int result = studentModel.updateScore(s1);
		return result;
	}

	/*public boolean displayConfirmGameEndMessage() {
		int returnValue = JOptionPane.showConfirmDialog(view.getWindow(), "Do you want to continue? Click YES to continue or NO "
				+ "to quit the game",  "Confirm Dialog",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(returnValue == JOptionPane.YES_OPTION) {
			MainFrame.layCard.show(MainFrame.getTopPanel(), "2");
			resetGame();
			return false;

		} else {
			//gameOverForQuitButton();
			resetGame();
			MainFrame.layCard.show(MainFrame.getTopPanel(), "5");	
			return true;
		}

	}*/

	/* if enter key is pressed or "next" button is clicked following function will get executed */
	public void doEnterPressed() {
		String str = null;
		if(getCupCakeCount() == studentInput) {
			studentScore =  studentScore + 1;
			str = "Yummy !!";
			playMusic(pathToMusic+"yummy.wav");
		} else if(getCupCakeCount() != studentInput){
			str = "OOPS !!!! ";
			playMusic(pathToMusic+"e-oh.wav");
		}
		JOptionPane.showMessageDialog(view.getWindow(), str , "Message Dialog", JOptionPane.PLAIN_MESSAGE);
		timer.stop();
		setCupCakeCount(0);
		Cupcake.start();
		if(getQuestionNumber() < 5) {
			generateQuestion();
			view.getjPanel1().repaint();
			
		} else {
			gameOverMessageDisplay();
		}
	}

	// action performed by timer
	public void actionPerformed(ActionEvent e) {
		// move the model by one step
		//for (int i = 0; i < model.size(); i++) {
		for(int j = 0; j < getCupCakeCount(); j++) {
			model.get(j).step(); 	
		}
		//}   
		// call the paintComponent method in view
		view.getWindow().repaint();
	}

	//draw shape
	public void update(Graphics2D myGraphics) {
		for (int i = 0; i < model.size(); i++)
			model.get(i).drawShape(myGraphics);
	}
}
