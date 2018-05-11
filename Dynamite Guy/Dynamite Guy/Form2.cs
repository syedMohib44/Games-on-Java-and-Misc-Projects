using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WMPLib;

namespace Dynamite_Guy
{
    public partial class Form2 : Form
    {
        WindowsMediaPlayer player = new WindowsMediaPlayer();
        public Form2()
        {
            InitializeComponent();
            player.URL = "HomePage.mp3";
        }
        
        private void button1_Click(object sender, EventArgs e)
        {
            player.controls.stop();
            Form form1 = new Form1();
            this.Hide();
            form1.Show();
            player.controls.stop();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form howto = new Form4();
            this.Hide();
            howto.Show();
            player.controls.stop();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Form aboutus = new Form3();
            this.Hide();
            aboutus.Show();
            player.controls.stop();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void panel4_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button5_Click(object sender, EventArgs e)
        {
            Form highscore = new Form5();
            this.Hide();
            highscore.Show();
            player.controls.stop();
        }
        private void Form2_Load(object sender, EventArgs e)
        {
            player.controls.play();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {

        }
    }
}
