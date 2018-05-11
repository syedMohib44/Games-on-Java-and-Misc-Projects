using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Windows.Forms;

namespace Dynamite_Guy
{
    public partial class Form5 : Form
    {
        public Form5()
        {
            InitializeComponent();
        }

        private void Form5_Load(object sender, EventArgs e)
        {
            string str = null;
            int scored = 0;
            StreamReader score = new StreamReader(@"score.txt");
            while ((str = score.ReadLine()) != null)
            {
                if (int.Parse(str) > scored)
                {
                    scored = int.Parse(str);
                }
                score.ReadLine();
            }
            label1.Text = scored.ToString();
            score.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form home = new Form2();
            this.Hide();
            home.Show();
        }
    }
}
