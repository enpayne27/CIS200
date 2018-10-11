using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/**
 * This class is a simple slide puzzle game with the 
 * objective arraging 15 tiles in numerical order.
 * This class manages the general flow of the game.
 * 
 * Erin Payne
 * Project 8
 * Friday 7:30
 */
namespace Project_8
{
    public partial class Form1 : Form
    {
        private Button[,] buttons;
        private int blankRow;
        private int blankColumn;
        private int row;
        private int column;
        private List<int> buttonArray = new List<int>();

        public Form1()
        {
            InitializeComponent();

            //Set button array
            buttons = new Button[4, 4];
            buttons[0, 0] = button1;
            buttons[0, 1] = button2;
            buttons[0, 2] = button3;
            buttons[0, 3] = button4;
            buttons[1, 0] = button5;
            buttons[1, 1] = button6;
            buttons[1, 2] = button7;
            buttons[1, 3] = button8;
            buttons[2, 0] = button9;
            buttons[2, 1] = button10;
            buttons[2, 2] = button11;
            buttons[2, 3] = button12;
            buttons[3, 0] = button13;
            buttons[3, 1] = button14;
            buttons[3, 2] = button15;
            buttons[3, 3] = button16; //Blank button

            ShuffleArray();
            //For every time a button is clicked by the user, access move method
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    buttons[i, j].Click += new EventHandler(Move);
                }
            }
        }

        /**
        * This method shuffles the button array before the start of each game.
        */
        public void ShuffleArray()
        {
            Random r = new Random();
            int temp;

            for (int i = 0; i < 4; i++) 
            {
                for (int j = 0; j < 4; j++) 
                { 
                    do
                    {
                        temp = r.Next(16);
                    }while(buttonArray.Contains(temp));

                    buttonArray.Add(temp);
                    buttons[i, j].Text = (temp).ToString();

                    if (buttons[i, j].Text == "0")
                    {
                        buttons[i, j].Visible = false;
                        blankRow = i;
                        blankColumn = j;
                    }
                }
            }
        }

        /**
        * This method checks whether the user has arranged the game in proper numerical order.
        *
        * Returns a boolean of whether the user has won the game.
        */
        private bool Win()
        {
            int [,] checkVal = new int[4, 4] {
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 0},
                             };

            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (Int32.Parse(buttons[i, j].Text) != checkVal[i, j]) return false;
                }
            }
            return true;
        }

        /**
        * This method disables the use of the buttons after the user has won.
        */
        private void DisableButtons()
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    buttons[i, j].Enabled = false;
                }
            }
        }


        /**
        * This method allows the user to move each button (sliding tile) when clicked.
        *
        * Receives button object.
        * Recieves what kind of action is made on button by user(such as a click)
        */ 
        private void Move(object sender, EventArgs e)
        {
            Button clicked = (Button)sender;
            String temp;

            //Saves button locations
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (clicked.Text == buttons[i, j].Text)
                    {
                        row = i;
                        column = j;
                    }
                }
            }
            buttons[blankRow, blankColumn].Visible = true;

            //Checks if blank spot is in same column as clicked
            if (column == blankColumn)
            {
                if (row < blankRow)
                {
                    while (clicked.Text != "0")
                    {
                        for (int i = row; i < blankRow; i++)
                        {
                            temp = buttons[i, column].Text;
                            buttons[i, column].Text = buttons[i + 1, column].Text;
                            buttons[i + 1, column].Text = temp;
                        }
                    }
                    blankRow = row;
                }
                if (row > blankRow)
                {
                    while (clicked.Text != "0")
                    {
                        for (int i = row; i > blankRow; i--)
                        {
                            temp = buttons[i, column].Text;
                            buttons[i, column].Text = buttons[i - 1, column].Text;
                            buttons[i - 1, column].Text = temp;
                        }
                    }
                    blankRow = row;
                }
            }

            //Checks if blank spot is in same row as clicked
            if (row == blankRow)
            {
                if (column < blankColumn)
                {
                    while (clicked.Text != "0")
                    {
                        for (int i = column; i < blankColumn; i++)
                        {
                            temp = buttons[row, i].Text;
                            buttons[row, i].Text = buttons[row, i + 1].Text;
                            buttons[row, i + 1].Text = temp;
                        }
                    }
                    blankColumn = column;
                }
                if (column > blankColumn)
                {
                    while (clicked.Text != "0")
                    {
                        for (int i = column; i > blankColumn; i--)
                        {
                            temp = buttons[row, i].Text;
                            buttons[row, i].Text = buttons[row, i - 1].Text;
                            buttons[row, i - 1].Text = temp;
                        }
                    }
                    blankColumn = column;
                }

            }
            buttons[blankRow, blankColumn].Visible = false;

            //Checks if user has won
            if (Win() == true)
                {
                    DisableButtons();
                    uxWin.Visible = true;
                    uxWin.Text = "You win!";
                }
            }
        }
    }