using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ShowAnimal;

namespace ZooMap
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btn_tiger_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            IDrawAnimal animal = new Tiger();
            animal.ShowAnimal(ghs, 90, 60);
            ghs.Dispose();
        }

        private void btn_elephont_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            IDrawAnimal animal = new Elenphont();
            animal.ShowAnimal(ghs, 420, 180);
            ghs.Dispose();
        }

        private void btn_swan_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            IDrawAnimal animal = new Swan();
            animal.ShowAnimal(ghs, 670, 20);
            ghs.Dispose();
        }

        private void btn_panda_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            IDrawAnimal animal = new Panda();
            animal.ShowAnimal(ghs, 210, 405);
            ghs.Dispose();
        }

        private void btn_monkey_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            IDrawAnimal animal = new GoldenMonkey();
            animal.ShowAnimal(ghs, 754, 381);
            ghs.Dispose();
        }
    }
}
