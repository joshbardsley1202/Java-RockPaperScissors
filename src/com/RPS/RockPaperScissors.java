package com.RPS;
//C:\Users\student\Desktop\Jacob H
// Rock-Paper-Scissors project ID-Tech FINAL

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; //Random number Generator

public class RockPaperScissors {

	private static JFrame frame = new JFrame();
	private static JTextField txbUserInput = new JTextField();
	public static JButton btnRock = new JButton("");
	public static JButton btnPaper = new JButton("");
	public static JButton btnScissors = new JButton("");
	public static JLabel lblInstructions = new JLabel("");
	public static JLabel lblInfo = new JLabel("New label", SwingConstants.CENTER);
	public static JLabel lblRange = new JLabel("New label", SwingConstants.CENTER); 
	public static JLabel lblScore = new JLabel("", SwingConstants.CENTER);
	public static String playerName;
	//Public Variables
	public static int cpuRPS = 0;
	public static boolean keepPlaying = true;
	public static boolean Rock = false;
	public static boolean Paper = false;
	public static boolean Scissors = false;



	// Launches the application.
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RockPaperScissors window = new RockPaperScissors();
					window.frame.setVisible(true);
					 btnRock.setEnabled(false);
						btnPaper.setEnabled(false);
						btnScissors.setEnabled(false);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		//***************************************************************************************************************************************MAIN CODE HERE:
		//Variables
		int Playing = 0;
		int playerPoints = 0;
		int cpuPoints = 0;

	
		
		
		//Introduction
		lblInfo.setText("Hello, Welcome to Rock, Paper, Scissors!");
		lblRange.setText("What is your name?");
		playerName = txbUserInput.getText();
		
	 

		//KEY-PRESS Event for btnOk & Continue
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(279, 247, 62, 25);
		frame.getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playerName.equals(""))
				playerName = txbUserInput.getText();
				String playerChoice = txbUserInput.getText();
				if (playerChoice.contains(("yes").toLowerCase()))
				{
					lblRange.setText("");
					lblInfo.setText("Awesome " + playerName + " let's play! Click to begin!");
					btnRock.setEnabled(true);
					btnPaper.setEnabled(true);
					btnScissors.setEnabled(true);
					//TIMER FOR ^lblInfo.setText("Awesome " + playerName + " let's play!");
					long Now= System.currentTimeMillis();
					if (System.currentTimeMillis() - Now < 2000)
					{
					} else {
						lblInfo.setText("");
						lblInstructions.setText("Click the Rock the Paper, or the Scissors!");
					}
				}	

				//If the player chooses no
				else if (playerChoice.equals("no"))
				{
					lblInfo.setText("Bummer " + playerName + " we can play again later!");
					keepPlaying = false;
				}
				else
				{
					txbUserInput.setText("");
					lblInfo.setText("Hello " + playerName + ", would you like to play?");
					lblRange.setText("Yes or no?");	
				}

			}
		});

///
		do {
			keepPlaying = true;
			while (Playing < 4)
			{
				String playerRPS = txbUserInput.getText();

				//If the player rolls ROCK, and the cpu rolls PAPER.
				if (Rock == true && cpuRPS == 2)
				{
					Playing++;
					cpuPoints++;
					if (cpuPoints >= 2)
					{
						lblInfo.setText("The computer choose Paper! ");
						lblRange.setText("Game Over! CPU Wins!");
						lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
						break;
					}
					lblInfo.setText("The CPU choose Paper!");
					lblRange.setText("You loose!");
					lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					Rock = false;
				}

				//If the player rolls PAPER, and the cpu rolls SCISSORS.
				else if (Paper == true && cpuRPS == 3)
				{
					Playing++;
					cpuPoints++;
					if (cpuPoints >= 2)
					{
						lblInfo.setText("The computer choose Scissors!");
						lblRange.setText("Game Over! CPU Wins!");
						lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					}
					lblInfo.setText("The computer choose Scissors!");
					lblRange.setText("You loose!");
					lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);	
					Paper = false;
				}

				//If the player rolls SCISSORS, and cpu rolls ROCK.
				else if (Scissors == true && cpuRPS == 1)
				{
					Playing++;
					cpuPoints++;
					if (cpuPoints >= 2)
					{
						lblInfo.setText("The computer choose Rock!");
						lblRange.setText("Game over! CPU wins!");
						lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					}
					lblInfo.setText("The computer choose Rock!");
					lblRange.setText("You loose!");
					lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					Scissors = false;
				}

				//If playerRPS rolls ROCK, cpuRPS rolls SCISSORS.
				else if (Rock == true && cpuRPS == 3)
				{
					Playing++;
					playerPoints++;
					if (playerPoints >= 2)
					{
						lblInfo.setText("The computer choose Scissors!");
						lblRange.setText("You win! Good game!");
						lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					}
					lblInfo.setText("The computer choose Scissors!");
					lblRange.setText("You win!");
					lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);	
					Rock = false;
				}

				//If playerRPS rolls SCISSORS, cpuRPS rolls PAPER.
				else if (Scissors == true && cpuRPS == 2)
				{
					Playing++;
					playerPoints++;
					if (playerPoints >= 2)
					{
						lblInfo.setText("The computer choose Paper!");
						lblRange.setText("You win! Good game!");
						lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					}
					lblInfo.setText("The computer choose Paper!");
					lblRange.setText("You win!");
					lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					Scissors = false;
				}

				//If playerRPS rolls PAPER, cpuRPS rolls ROCK.
				else if (Paper == true && cpuRPS == 1)
				{
					playerPoints++;
					Playing++;
					if (playerPoints >= 2)
					{
						lblInfo.setText("The computer choose Rock!");
						lblRange.setText("You win! Good game!");
						lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					}
					lblInfo.setText("The computer choose Rock!");
					lblRange.setText("You win!");
					lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					Scissors = false;
				}


				//If the player rolls ROCK and the CPU rolls ROCK.
				else if (Rock == true && cpuRPS == 1)
				{
					lblInfo.setText("Oops! looks the CPU choose Rock also!");
					lblRange.setText("It's a tie, Try again!");
					lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					Rock = false;
				}	

				//If the player rolls PAPER and the CPU rolls PAPER.
				else if (Paper == true && cpuRPS == 2)
				{
					lblInfo.setText("Oops! looks the CPU choose Paper also!");
					lblRange.setText("It's a tie, Try again!");
					lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					Paper = false;
				}

				//If the player rolls SCISSORS and the CPU rolls SCISSORS.
				else if (Scissors == true && cpuRPS == 3)
				{
					lblInfo.setText("Oops! looks the CPU choose Scissors also!");
					lblRange.setText("It's a tie, Try again!");
					lblScore.setText(playerName + "'s Points: " + playerPoints + " | CPU's Points: " + cpuPoints);
					Scissors = false;
				}	
			}	
		} while (keepPlaying == true);
	}

	public static void numGenerator()
	{
		Random num = new Random();
		cpuRPS = num.nextInt(3)+1;
	}
	//*******************************************************************************************************************************************MAIN CODE ABOVE:



	//Creates the application. 
	public RockPaperScissors() {
		initialize();
	}

	//Initialize the contents of the frame.
	private void initialize() {
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblRockpaperscissors = new JLabel("Rock-Paper-Scissors!");
		lblRockpaperscissors.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRockpaperscissors.setBounds(141, 0, 164, 29);
		frame.getContentPane().add(lblRockpaperscissors);
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rock = true;
				numGenerator();
			}
		});

		btnRock.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/com/RPS/Rock_Icon.gif.gif")));
		btnRock.setBounds(12, 42, 125, 125);
		frame.getContentPane().add(btnRock);
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paper = true;
				numGenerator();
			}
		});

		btnPaper.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/com/RPS/Paper_Icon.gif")));
		btnPaper.setBounds(151, 42, 125, 125);
		frame.getContentPane().add(btnPaper);
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scissors = true;
				numGenerator();
			}
		});

		btnScissors.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/com/RPS/Scissors_Icon.gif.gif")));
		btnScissors.setBounds(295, 42, 125, 125);
		frame.getContentPane().add(btnScissors);


		lblInstructions.setBounds(92, 180, 235, 16);
		frame.getContentPane().add(lblInstructions);

		lblInfo.setBounds(55, 196, 304, 16);
		frame.getContentPane().add(lblInfo);

		lblRange.setBounds(142, 209, 146, 16);
		frame.getContentPane().add(lblRange);

		lblScore.setBounds(92, 287, 235, 16);
		frame.getContentPane().add(lblScore);

		txbUserInput.setText("");
		txbUserInput.setBounds(92, 248, 175, 22);
		frame.getContentPane().add(txbUserInput);
		txbUserInput.setColumns(10);
	}
}
