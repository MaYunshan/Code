using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 所有字体
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.BackColor = Color.White;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            Graphics ghs = e.Graphics;
            ghs.TranslateTransform(AutoScrollPosition.X, AutoScrollPosition.Y);

            Point position = new Point(5, 0);
            foreach (FontFamily family in FontFamily.Families)
            {
                if(family.IsStyleAvailable(FontStyle.Regular))
                {
                    Font font = new Font(family.Name, 10);
                    
                    ghs.DrawString(family.Name, font, Brushes.Black, position);
                    position.Y += font.Height + 5;
                    font.Dispose();
                }
                
            }
            this.AutoScrollMinSize=new Size(300, position.Y);
        }
    }
}
