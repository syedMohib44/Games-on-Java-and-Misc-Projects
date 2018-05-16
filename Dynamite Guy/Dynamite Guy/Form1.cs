using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using WMPLib;

namespace Dynamite_Guy
{
    public partial class Form1 : Form
    {
        WindowsMediaPlayer expload = new WindowsMediaPlayer();
        WindowsMediaPlayer player = new WindowsMediaPlayer();

        public Form1()
        {
            InitializeComponent();
            player.URL = "GamePlay.mp3";
            expload.URL = "Bomb_Exploding-Sound.mp3";
        }

        Random r = new Random();

        public void stopall()
        {
            ExplosionTimer.Stop();
            EnemyTimer.Stop();
            EnemyTimer1.Stop();
            EnemyTimer2.Stop();
            EnemyTimer3.Stop();
            EnemyTimer4.Stop();
            BombTimer.Stop();
        }
        public void life()
        {
            if ( (P1.Bounds.IntersectsWith(enemy1.Bounds) && enemy1.Visible == true) || (P1.Bounds.IntersectsWith(enemy2.Bounds) && enemy2.Visible == true) || (P1.Bounds.IntersectsWith(enemy3.Bounds) && enemy3.Visible == true) || (P1.Bounds.IntersectsWith(enemy4.Bounds) && enemy4.Visible == true) || (P1.Bounds.IntersectsWith(enemy5.Bounds) && enemy5.Visible == true))
            {
                if (i == 1)
                {
                    DEAD1.Visible = true;
                    P1.Location = new Point(pictureBox1.Location.X - 90, pictureBox27.Location.Y + 60);
                }
                if (i == 2)
                {
                    DEAD2.Visible = true;
                    P1.Location = new Point(pictureBox1.Location.X - 90, pictureBox27.Location.Y + 60);
                }
                if (i == 3)
                {
                    AnimeDie.Start();
                    DEAD3.Visible = true;
                    stopall();
                    MessageBox.Show("YOU SUCK!");
                    Form home = new Form2();
                    this.Hide();
                    home.Show();
                    player.controls.stop();
                }
                i++;
            }
        }
      
        public void woods()
        {
            if (wood.Visible && explosion1.Visible && explosion1.Bounds.IntersectsWith(wood.Bounds) || wood.Visible && explosion2.Visible && explosion1.Bounds.IntersectsWith(wood.Bounds) || wood.Visible && explosion3.Visible && explosion3.Bounds.IntersectsWith(wood.Bounds) || wood.Visible && explosion4.Visible && explosion4.Bounds.IntersectsWith(wood.Bounds))
            {
                wood.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 2);
                score.WriteLine(label1.Text);
                score.Close();

            }

            else if (wood1.Visible && explosion1.Visible && explosion1.Bounds.IntersectsWith(wood1.Bounds) || wood1.Visible && explosion2.Visible && explosion1.Bounds.IntersectsWith(wood1.Bounds) || wood1.Visible && explosion3.Visible && explosion3.Bounds.IntersectsWith(wood1.Bounds) || wood1.Visible && explosion4.Visible && explosion4.Bounds.IntersectsWith(wood1.Bounds))
            {
                wood1.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 2);
                score.WriteLine(label1.Text);
                score.Close();
            }

            else if (wood2.Visible && explosion1.Visible && explosion1.Bounds.IntersectsWith(wood2.Bounds) || wood2.Visible && explosion2.Visible && explosion1.Bounds.IntersectsWith(wood2.Bounds) || wood2.Visible && explosion3.Visible && explosion3.Bounds.IntersectsWith(wood2.Bounds) || wood2.Visible && explosion4.Visible && explosion4.Bounds.IntersectsWith(wood2.Bounds))
            {
                wood2.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 2);
                score.WriteLine(label1.Text);
                score.Close();
            }

            else if (wood3.Visible && explosion1.Visible && explosion1.Bounds.IntersectsWith(wood3.Bounds) || wood3.Visible && explosion2.Visible && explosion1.Bounds.IntersectsWith(wood3.Bounds) || wood3.Visible && explosion3.Visible && explosion3.Bounds.IntersectsWith(wood3.Bounds) || wood3.Visible && explosion4.Visible && explosion4.Bounds.IntersectsWith(wood3.Bounds))
            {
                wood3.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 2);
                score.WriteLine(label1.Text);
                score.Close();
            }

            else if (wood4.Visible && explosion1.Visible && explosion1.Bounds.IntersectsWith(wood4.Bounds) || wood4.Visible && explosion2.Visible && explosion1.Bounds.IntersectsWith(wood4.Bounds) || wood4.Visible && explosion3.Visible && explosion3.Bounds.IntersectsWith(wood4.Bounds) || wood4.Visible && explosion4.Visible && explosion4.Bounds.IntersectsWith(wood4.Bounds))
            {
                wood4.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 2);
                score.WriteLine(label1.Text);
                score.Close();
            }

            else if (wood5.Visible && explosion1.Visible && explosion1.Bounds.IntersectsWith(wood5.Bounds) || wood5.Visible && explosion2.Visible && explosion1.Bounds.IntersectsWith(wood5.Bounds) || wood5.Visible && explosion3.Visible && explosion3.Bounds.IntersectsWith(wood5.Bounds) || wood5.Visible && explosion4.Visible && explosion4.Bounds.IntersectsWith(wood5.Bounds))
            {
                wood5.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 2);
                score.WriteLine(label1.Text);
                score.Close();
            }

            else if (explosion1.Visible && explosion1.Bounds.IntersectsWith(wood6.Bounds) || explosion2.Visible && explosion1.Bounds.IntersectsWith(wood6.Bounds) || explosion3.Visible && explosion3.Bounds.IntersectsWith(wood6.Bounds) || explosion4.Visible && explosion4.Bounds.IntersectsWith(wood6.Bounds))
            {
                wood6.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 2);
                score.WriteLine(label1.Text);
                score.Close();
            }

            else if (explosion1.Visible && explosion1.Bounds.IntersectsWith(wood7.Bounds) || explosion2.Visible && explosion1.Bounds.IntersectsWith(wood7.Bounds) || explosion3.Visible && explosion3.Bounds.IntersectsWith(wood7.Bounds) || explosion4.Visible && explosion4.Bounds.IntersectsWith(wood7.Bounds))
            {
                wood7.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 2);
                score.WriteLine(label1.Text);
                score.Close();
            }



        }
        public bool CheckCollision()
        {
            if ((P1.Bounds.IntersectsWith(pictureBox1.Bounds) || P1.Bounds.IntersectsWith(pictureBox2.Bounds) || P1.Bounds.IntersectsWith(pictureBox3.Bounds) || P1.Bounds.IntersectsWith(pictureBox4.Bounds) || P1.Bounds.IntersectsWith(pictureBox5.Bounds) || P1.Bounds.IntersectsWith(pictureBox6.Bounds) || P1.Bounds.IntersectsWith(pictureBox7.Bounds) || P1.Bounds.IntersectsWith(pictureBox8.Bounds) || P1.Bounds.IntersectsWith(pictureBox9.Bounds) || P1.Bounds.IntersectsWith(pictureBox10.Bounds) || P1.Bounds.IntersectsWith(pictureBox11.Bounds) || P1.Bounds.IntersectsWith(pictureBox12.Bounds) || P1.Bounds.IntersectsWith(pictureBox13.Bounds) || P1.Bounds.IntersectsWith(pictureBox14.Bounds) || P1.Bounds.IntersectsWith(pictureBox15.Bounds) || P1.Bounds.IntersectsWith(pictureBox16.Bounds) || P1.Bounds.IntersectsWith(pictureBox17.Bounds) || P1.Bounds.IntersectsWith(pictureBox18.Bounds) || P1.Bounds.IntersectsWith(pictureBox19.Bounds) || P1.Bounds.IntersectsWith(pictureBox20.Bounds) || P1.Bounds.IntersectsWith(pictureBox21.Bounds) || P1.Bounds.IntersectsWith(pictureBox22.Bounds) || P1.Bounds.IntersectsWith(pictureBox23.Bounds) || P1.Bounds.IntersectsWith(pictureBox24.Bounds) || P1.Bounds.IntersectsWith(pictureBox25.Bounds) || P1.Bounds.IntersectsWith(pictureBox26.Bounds) || P1.Bounds.IntersectsWith(pictureBox27.Bounds) || P1.Bounds.IntersectsWith(pictureBox28.Bounds) || (P1.Bounds.IntersectsWith(wood.Bounds) && wood.Visible) || (P1.Bounds.IntersectsWith(wood1.Bounds) && wood1.Visible) || (P1.Bounds.IntersectsWith(wood2.Bounds) && wood2.Visible) || (P1.Bounds.IntersectsWith(wood3.Bounds) && wood3.Visible) || (P1.Bounds.IntersectsWith(wood4.Bounds) && wood4.Visible) || (P1.Bounds.IntersectsWith(wood5.Bounds) && wood5.Visible) || (P1.Bounds.IntersectsWith(wood6.Bounds) && wood6.Visible) || (P1.Bounds.IntersectsWith(wood7.Bounds) && wood7.Visible)))
            {

                return true;
            }
            return false;
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            P1.Image = Properties.Resources._11;
            P1.SizeMode = PictureBoxSizeMode.AutoSize;
            P1.BringToFront();
            bomb.Image = Properties.Resources.dynamite2;
            bomb.SizeMode = PictureBoxSizeMode.StretchImage;
            bomb.Location = P1.Location;
            bomb.BringToFront();
            EnemyTimer.Start();
            EnemyTimer1.Start();
            EnemyTimer2.Start();
            EnemyTimer3.Start();
            EnemyTimer4.Start();

        }
        int i = 0;

        public bool lf = false;

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            lf = true;
            if (e.KeyCode == Keys.Left && !CheckCollision())
            {
                Anime.Start();
                P1.Location = new Point(P1.Location.X - 4, P1.Location.Y);
            }
            else if (e.KeyCode == Keys.Left && CheckCollision())
            {
                P1.Location = new Point(P1.Location.X + 4, P1.Location.Y);
            }

            if (e.KeyCode == Keys.Right && !CheckCollision())
            {
                AnimeRight.Start();
                P1.Location = new Point(P1.Location.X + 5, P1.Location.Y);
            }
            else if (e.KeyCode == Keys.Right && CheckCollision())
            {
                P1.Location = new Point(P1.Location.X - 4, P1.Location.Y);
            }

            if (e.KeyCode == Keys.Up && !CheckCollision())
            {
                P1.Location = new Point(P1.Location.X, P1.Location.Y - 5);
                AnimeUp.Start();
            }
            else if (e.KeyCode == Keys.Up && CheckCollision())
            {
                P1.Location = new Point(P1.Location.X, P1.Location.Y + 4);
            }

            if (e.KeyCode == Keys.Down && !CheckCollision())
            {
                P1.Location = new Point(P1.Location.X, P1.Location.Y + 5);
                AnimeDown.Start();
            }
            else if (e.KeyCode == Keys.Down && CheckCollision())
            {
                P1.Location = new Point(P1.Location.X, P1.Location.Y - 4);
            }
            if (e.KeyCode == Keys.Z && bomb.Visible == false)
            {
                bomb.Image = Properties.Resources.graphics_bombs_934360;
                bomb.Location = P1.Location;
                bomb.Visible = true;
                BombTimer.Start();
            }
            if (e.KeyCode == Keys.P)
            {
                ExplosionTimer.Stop();
                EnemyTimer.Stop();
                EnemyTimer1.Stop();
                EnemyTimer2.Stop();
                EnemyTimer3.Stop();
                EnemyTimer4.Stop();
                player.controls.stop();
                BombTimer.Stop();
                label2.Visible = true;
                pictureBox29.Visible = true;
                P1.Visible = false;
                bomb.Visible = false;
                explosion1.Visible = false;
                explosion2.Visible = false;
                explosion3.Visible = false;
                explosion4.Visible = false;
            }
            if (e.KeyCode == Keys.R)
            {
                EnemyTimer.Start();
                EnemyTimer1.Start();
                EnemyTimer2.Start();
                EnemyTimer3.Start();
                EnemyTimer4.Start();
                player.controls.play();
                label2.Visible = false;
                pictureBox29.Visible = false;
                P1.Visible = true;

            }
            //if ((P1.Bounds.IntersectsWith(enemy1.Bounds) && enemy1.Visible == true) || (P1.Bounds.IntersectsWith(enemy2.Bounds) && enemy2.Visible == true) || (P1.Bounds.IntersectsWith(enemy3.Bounds) && enemy3.Visible == true) || (P1.Bounds.IntersectsWith(enemy4.Bounds) && enemy4.Visible == true) || (P1.Bounds.IntersectsWith(enemy5.Bounds) && enemy5.Visible == true))
            ////if (explosion1.Visible && P1.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && P1.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && P1.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && P1.Bounds.IntersectsWith(explosion4.Bounds))
            //{
            //    DEAD3.Visible = true;
            //    P1.Dispose();
            //    stopall();
            //    MessageBox.Show("YOU SUCK!");
            //    Form home = new Form2();
            //    this.Hide();
            //    home.Show();
            //}
            else if (enemy1.Visible == false && enemy2.Visible == false && enemy3.Visible == false && enemy4.Visible == false && enemy5.Visible == false)
            {
                MessageBox.Show("YOU WON!");
                Form home = new Form2();
                this.Hide();
                home.Show();
            }

        }


        private void pictureBox21_Click(object sender, EventArgs e)
        {

        }
        int bomb3tick = 0;
        private void BombTimer_Tick(object sender, EventArgs e)
        {
            if (bomb3tick == 4)
            {
                BombTimer.Stop();
                expload.controls.play();
                explosion1.Visible = true;
                explosion2.Visible = true;
                explosion3.Visible = true;
                explosion4.Visible = true;
                explosion1.Location = new Point(bomb.Location.X, bomb.Location.Y - 50);
                explosion2.Location = new Point(bomb.Location.X + 50, bomb.Location.Y);
                explosion3.Location = new Point(bomb.Location.X, bomb.Location.Y + 50);
                explosion4.Location = new Point(bomb.Location.X - 50, bomb.Location.Y);
                ExplosionTimer.Start();
            }
            bomb3tick++;

        }
        int bombe1tick = 0;
        private void ExplosionTimer_Tick(object sender, EventArgs e)
        {

            if (bombe1tick == 5)
            {
                ExplosionTimer.Stop();
                bomb.Visible = false;
                explosion1.Visible = false;
                explosion2.Visible = false;
                explosion3.Visible = false;
                explosion4.Visible = false;
                bomb3tick = 0;
                bombe1tick = 0;
            }
            bombe1tick++;
            woods();            
            life();
        }

        private void pictureBox26_Click(object sender, EventArgs e)
        {

        }
        int enemyticks = 0;
        char direction = 'w';
        private void EnemyTimer_Tick(object sender, EventArgs e)
        {
            if (explosion1.Visible && enemy1.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy1.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy1.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy1.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy1.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 5);
                score.WriteLine(label1.Text);
                score.Close();
            }
            if (explosion1.Visible && enemy2.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy2.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy2.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy2.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy2.Dispose();
                label1.Text = Convert.ToString(scores += 5);
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 5);
                score.WriteLine(label1.Text);
                score.Close();
            }
            if (explosion1.Visible && enemy3.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy3.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy3.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy3.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy3.Dispose();
                label1.Text = Convert.ToString(scores += 5);
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 5);
                score.WriteLine(label1.Text);
                score.Close();
            }
            if (explosion1.Visible && enemy4.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy4.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy4.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy4.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy4.Dispose();
                label1.Text = Convert.ToString(scores += 5);
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 5);
                score.WriteLine(label1.Text);
                score.Close();
            }
            if (explosion1.Visible && enemy5.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy5.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy5.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy5.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy5.Dispose();
                label1.Text = Convert.ToString(scores += 5);
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 5);
                score.WriteLine(label1.Text);
                score.Close();
            }
            life();

            if (direction == 'w')
            {
                if (enemy1.Location.Y > 70)
                {
                    enemy1.Location = new Point(enemy1.Location.X, enemy1.Location.Y - 5);
                    enemy1.Image = Properties.Resources.up;
                }


                else
                {
                    direction = 'd';
                }
                if (enemy1.Bounds.IntersectsWith(wood.Bounds) || enemy1.Bounds.IntersectsWith(pictureBox1.Bounds))
                {
                    enemy1.Location = new Point(enemy1.Location.X - 5, enemy1.Location.Y + 5);
                    enemy1.Image = Properties.Resources.left;
                    enemy1.SizeMode = PictureBoxSizeMode.CenterImage;
                }

            }

            else if (direction == 'd')
            {
                if (enemy1.Location.Y < (this.Height - 150))
                {
                    enemy1.Location = new Point(enemy1.Location.X, enemy1.Location.Y + 5);
                    enemy1.Image = Properties.Resources.down;

                }
                else
                {
                    direction = 'w';
                }
                if (enemy1.Bounds.IntersectsWith(wood2.Bounds) || enemy1.Bounds.IntersectsWith(pictureBox20.Bounds))
                {
                    enemy1.Location = new Point(enemy1.Location.X + 5, enemy1.Location.Y - 5);
                    enemy1.Image = Properties.Resources.right;
                }


            }

        }
        int enemyticks1 = 0;
        char direction1 = 'w';
        private void EnemyTimer1_Tick(object sender, EventArgs e)
        {
            if (explosion1.Visible && enemy1.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy1.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy1.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy1.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy1.Dispose();
            }
            if (explosion1.Visible && enemy2.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy2.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy2.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy2.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy2.Dispose();
            }
            if (explosion1.Visible && enemy3.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy3.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy3.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy3.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy3.Dispose();
            }
            if (explosion1.Visible && enemy4.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy4.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy4.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy4.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy4.Dispose();
            }
            if (explosion1.Visible && enemy5.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy5.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy5.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy5.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy5.Dispose();
            }

            if (direction1 == 'w')
            {
                player.controls.play();
                if (enemy2.Location.Y > 70)
                {
                    enemy2.Location = new Point(enemy2.Location.X, enemy2.Location.Y - 8);
                    enemy2.Image = Properties.Resources.upRED;
                }
                else
                {
                    direction1 = 'd';
                }
                if (enemy2.Bounds.IntersectsWith(wood.Bounds) || enemy2.Bounds.IntersectsWith(pictureBox2.Bounds))
                {
                    enemy2.Location = new Point(enemy2.Location.X + 8, enemy2.Location.Y + 8);
                    enemy2.Image = Properties.Resources.rightRED;
                }
            }
            else if (direction1 == 'd')
            {
                player.controls.play();

                if (enemy2.Location.Y < (this.Height - 150))
                {
                    enemy2.Location = new Point(enemy2.Location.X, enemy2.Location.Y + 8);
                    enemy2.Image = Properties.Resources.downRED;
                }
                else
                {
                    direction1 = 'w';
                }
                if (enemy2.Bounds.IntersectsWith(wood6.Bounds) || enemy2.Bounds.IntersectsWith(pictureBox23.Bounds))
                {
                    enemy2.Location = new Point(enemy2.Location.X - 8, enemy2.Location.Y - 8);
                    enemy2.Image = Properties.Resources.leftRED;
                }
            }
        }
        int enemyticks2 = 0;
        char direction2 = 'w';
        private void EnemyTimer2_Tick(object sender, EventArgs e)
        {
            if (explosion1.Visible && enemy1.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy1.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy1.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy1.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy1.Dispose();
            }
            if (explosion1.Visible && enemy2.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy2.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy2.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy2.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy2.Dispose();
            }
            if (explosion1.Visible && enemy3.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy3.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy3.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy3.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy3.Dispose();
            }
            if (explosion1.Visible && enemy4.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy4.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy4.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy4.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy4.Dispose();
            }
            if (explosion1.Visible && enemy5.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy5.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy5.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy5.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy5.Dispose();
            }


            if (direction2 == 'w')
            {
                if (enemy3.Location.Y > 80)
                {
                    enemy3.Location = new Point(enemy3.Location.X, enemy3.Location.Y - 10);
                    enemy3.Image = Properties.Resources.upEnemy;
                }
                else
                {
                    direction2 = 'd';
                }

            }
            else if (direction2 == 'd')
            {
                if (enemy3.Location.Y < (this.Height - 150))
                {
                    enemy3.Location = new Point(enemy3.Location.X, enemy3.Location.Y + 10);
                    enemy3.Image = Properties.Resources.downEnemy;
                }
                else
                {
                    direction2 = 'w';
                }
            }
        }

        int enemyticks3 = 0;
        char direction3 = 'w';
        private void EnemyTimer3_Tick(object sender, EventArgs e)
        {
            if (explosion1.Visible && enemy1.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy1.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy1.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy1.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy1.Dispose();
            }
            if (explosion1.Visible && enemy2.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy2.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy2.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy2.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy2.Dispose();
            }
            if (explosion1.Visible && enemy3.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy3.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy3.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy3.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy3.Dispose();
            }
            if (explosion1.Visible && enemy4.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy4.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy4.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy4.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy4.Dispose();
            }
            if (explosion1.Visible && enemy5.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy5.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy5.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy5.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy5.Dispose();
            }

            if (direction3 == 'w')
            {
                if (enemy4.Location.Y > 80)
                {
                    enemy4.Location = new Point(enemy4.Location.X, enemy4.Location.Y - 4);
                    enemy4.Image = Properties.Resources.upGREEN;
                }
                else
                {
                    direction3 = 'd';
                }
                if (enemy4.Bounds.IntersectsWith(wood3.Bounds) || enemy4.Bounds.IntersectsWith(pictureBox8.Bounds))
                {
                    enemy4.Location = new Point(enemy4.Location.X + 4, enemy4.Location.Y + 4);
                    enemy4.Image = Properties.Resources.rightGREEN;
                }
                if (enemy4.Bounds.IntersectsWith(wood1.Bounds) || enemy4.Bounds.IntersectsWith(pictureBox5.Bounds))
                {
                    enemy4.Location = new Point(enemy4.Location.X - 4, enemy4.Location.Y + 4);
                    enemy4.Image = Properties.Resources.leftGREEN;
                }
            }
            else if (direction3 == 'd')
            {
                if (enemy4.Location.Y < (this.Height - 150))
                {
                    enemy4.Location = new Point(enemy4.Location.X, enemy4.Location.Y + 4);
                    enemy4.Image = Properties.Resources.downGREEN;
                }
                else
                {
                    direction3 = 'w';
                }
                if (enemy4.Bounds.IntersectsWith(wood3.Bounds) || enemy4.Bounds.IntersectsWith(pictureBox8.Bounds))
                {
                    enemy4.Location = new Point(enemy4.Location.X + 4, enemy4.Location.Y - 4);
                    enemy4.Image = Properties.Resources.rightGREEN;
                }
                if (enemy4.Bounds.IntersectsWith(wood7.Bounds) || enemy4.Bounds.IntersectsWith(pictureBox16.Bounds))
                {
                    enemy4.Location = new Point(enemy4.Location.X - 4, enemy4.Location.Y - 4);
                    enemy4.Image = Properties.Resources.leftGREEN;
                }
            }
        }

        int enemyticks4 = 0;
        char direction4 = 'w';
        private void EnemyTimer4_Tick(object sender, EventArgs e)
        {
            if (explosion1.Visible && enemy1.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy1.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy1.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy1.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy1.Dispose();
            }
            if (explosion1.Visible && enemy2.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy2.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy2.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy2.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy2.Dispose();
            }
            if (explosion1.Visible && enemy3.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy3.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy3.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy3.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy3.Dispose();
            }
            if (explosion1.Visible && enemy4.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy4.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy4.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy4.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy4.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 5);
                score.WriteLine(label1.Text);
                score.Close();
            }
            if (explosion1.Visible && enemy5.Bounds.IntersectsWith(explosion1.Bounds) || explosion2.Visible && enemy5.Bounds.IntersectsWith(explosion2.Bounds) || explosion3.Visible && enemy5.Bounds.IntersectsWith(explosion3.Bounds) || explosion4.Visible && enemy5.Bounds.IntersectsWith(explosion4.Bounds))
            {
                enemy5.Dispose();
                StreamWriter score = new StreamWriter(@"score.txt");
                label1.Text = Convert.ToString(scores += 5);
                score.WriteLine(label1.Text);
                score.Close();
            }


            if (direction4 == 'w')
            {
                if (enemy5.Location.Y > 90)
                {
                    enemy5.Location = new Point(enemy5.Location.X, enemy5.Location.Y - 12);
                    enemy5.Image = Properties.Resources.upBoss;
                }
                else
                {
                    direction4 = 'd';
                }
                if (enemy5.Bounds.IntersectsWith(wood1.Bounds) || enemy5.Bounds.IntersectsWith(pictureBox6.Bounds))
                {
                    enemy5.Location = new Point(enemy5.Location.X + 12, enemy5.Location.Y + 12);
                    enemy5.Image = Properties.Resources.rightBoss;
                }
                if (enemy5.Bounds.IntersectsWith(wood4.Bounds) || enemy5.Bounds.IntersectsWith(pictureBox7.Bounds))
                {
                    enemy5.Location = new Point(enemy5.Location.X - 12, enemy5.Location.Y + 12);
                    enemy5.Image = Properties.Resources.leftBoss;
                }
            }
            if (direction4 == 'd')
            {
                if (enemy5.Location.Y < (this.Height - 150))
                {
                    enemy5.Location = new Point(enemy5.Location.X, enemy5.Location.Y + 12);
                    enemy5.Image = Properties.Resources.downBoss;
                }
                else
                {
                    direction4 = 'w';
                }
                if (enemy5.Bounds.IntersectsWith(wood4.Bounds) || enemy5.Bounds.IntersectsWith(pictureBox7.Bounds))
                {
                    enemy5.Location = new Point(enemy5.Location.X - 12, enemy5.Location.Y - 12);
                    enemy5.Image = Properties.Resources.leftBoss;
                }
                if (enemy5.Bounds.IntersectsWith(wood7.Bounds) || enemy5.Bounds.IntersectsWith(pictureBox15.Bounds))
                {
                    enemy5.Location = new Point(enemy5.Location.X + 12, enemy5.Location.Y - 12);
                    enemy5.Image = Properties.Resources.rightBoss;
                }
                int convert = Convert.ToInt32(scores);

            }
        }
        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {

        }

        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Left)
            {
                Anime.Stop();
                Image img;
                img = Image.FromFile("" + 0 + ".gif");
                P1.Image = img;
            }
            if (e.KeyCode == Keys.Right)
            {
                AnimeRight.Stop();
                Image img;
                img = Image.FromFile("" + 5 + ".gif");
                P1.Image = img;
            }
            if (e.KeyCode == Keys.Up)
            {
                AnimeUp.Stop();
                Image img;
                img = Image.FromFile("" + 10 + ".gif");
                P1.Image = img;
            }
            if (e.KeyCode == Keys.Down)
            {
                AnimeDown.Stop();
                Image img;
                img = Image.FromFile("" + 15 + ".gif");
                P1.Image = img;
            }
        }

        private void enemy1_Click(object sender, EventArgs e)
        {

        }
        int scores = 0;
        private void label1_Click(object sender, EventArgs e)
        {
        }

        int counting = 0;    

        private void AnimeRight_Tick_1(object sender, EventArgs e)
        {
            counting++;
            if (counting == 1)
            {
                Image img;
                img = Image.FromFile("" + 6 + ".gif");
                P1.Image = img;
            }
            if (counting == 2)
            {
                Image img;
                img = Image.FromFile("" + 7 + ".gif");
                P1.Image = img;
            }
            if (counting == 3)
            {
                Image img;
                img = Image.FromFile("" + 8 + ".gif");
                P1.Image = img;
            }
            if (counting == 4)
            {
                Image img;
                img = Image.FromFile("" + 9 + ".gif");
                P1.Image = img;
                counting = 0;
            }
        }

        private void AnimeUp_Tick_1(object sender, EventArgs e)
        {
            counting++;
            if (counting == 1)
            {
                Image img;
                img = Image.FromFile("" + 11 + ".gif");
                P1.Image = img;
            }
            if (counting == 2)
            {
                Image img;
                img = Image.FromFile("" + 12 + ".gif");
                P1.Image = img;
            }
            if (counting == 3)
            {
                Image img;
                img = Image.FromFile("" + 13 + ".gif");
                P1.Image = img;
            }
            if (counting == 4)
            {
                Image img;
                img = Image.FromFile("" + 14 + ".gif");
                P1.Image = img;
                counting = 0;
            }
        }

        private void AnimeDown_Tick_1(object sender, EventArgs e)
        {
            counting++;
            if (counting == 1)
            {
                Image img;
                img = Image.FromFile("" + 16 + ".gif");
                P1.Image = img;
            }
            if (counting == 2)
            {
                Image img;
                img = Image.FromFile("" + 17 + ".gif");
                P1.Image = img;
            }
            if (counting == 3)
            {
                Image img;
                img = Image.FromFile("" + 18 + ".gif");
                P1.Image = img;
            }
            if (counting == 4)
            {
                Image img;
                img = Image.FromFile("" + 19 + ".gif");
                P1.Image = img;
                counting = 0;
            }
        }

        private void AnimeDie_Tick_1(object sender, EventArgs e)
        {
            counting++;
            if (counting == 1)
            {
                Image img;
                img = Image.FromFile("" + 20 + ".gif");
                P1.Image = img;
            }
            if (counting == 2)
            {
                Image img;
                img = Image.FromFile("" + 21 + ".gif");
                P1.Image = img;
            }
            if (counting == 3)
            {
                Image img;
                img = Image.FromFile("" + 22 + ".gif");
                P1.Image = img;
            }
            if (counting == 4)
            {
                Image img;
                img = Image.FromFile("" + 23 + ".gif");
                P1.Image = img;
            }
            if (counting == 5)
            {
                Image img;
                img = Image.FromFile("" + 24 + ".gif");
                P1.Image = img;
            }
            if (counting > 5)
            {
                P1.Dispose();
            }
        }

        private void Anime_Tick_1(object sender, EventArgs e)
        {
            counting++;
            if (counting == 1)
            {
                Image img;
                img = Image.FromFile("" + 1 + ".gif");
                P1.Image = img;
            }
            if (counting == 2)
            {
                Image img;
                img = Image.FromFile("" + 2 + ".gif");
                P1.Image = img;
            }
            if (counting == 3)
            {
                Image img;
                img = Image.FromFile("" + 3 + ".gif");
                P1.Image = img;
            }
            if (counting == 4)
            {
                Image img;
                img = Image.FromFile("" + 4 + ".gif");
                P1.Image = img;
                counting = 0;
            }
        }
    }
} 
