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
using System.Media;

namespace 音乐播放器
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        List<string> listSongs;     //声明一个泛型集合用来存储被选中的音乐路径
        SoundPlayer sp;            //音乐播放器的对象
        private void Form1_Load(object sender, EventArgs e)
        {
             listSongs = new List<string>();    
             sp = new SoundPlayer();
        }

        /// <summary>
        /// 将选中的音乐文件添加到listbox1中
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn_open_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.InitialDirectory = @"D:\12345C#\WAV\WAV";
            ofd.Multiselect = true;
            ofd.Filter = "音乐文件|*.wav|所有文件|*.*";
            ofd.ShowDialog();

            string[] paths = ofd.FileNames;
            foreach(string path in paths)
            {
                //将音乐文件名添加到listbox中
                listBox1.Items.Add(Path.GetFileName(path));
                //将完整路径名添加到泛型集合list中
                listSongs.Add(path);
            }
        }

        private void listBox1_DoubleClick(object sender, EventArgs e)
        {

            sp.SoundLocation = listSongs[listBox1.SelectedIndex];
            sp.Play();
        }

        /// <summary>
        /// 单击播放下一首歌曲                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn_next_Click(object sender, EventArgs e)
        {
            //获得当前歌曲的索引
            int index = listBox1.SelectedIndex;
            //索引指向下一首
            index++;
            //如果已经到最后一首，指向第一首
            if(index==listBox1.Items.Count)
            {
                index = 0;
            }
            //选中框选中即将要播放的下一首歌曲
            listBox1.SelectedIndex = index;
            sp.SoundLocation = listSongs[index];
            sp.Play();
        }

        /// <summary>
        /// 单击播放上一曲
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn_prew_Click(object sender, EventArgs e)
        {
            int index = listBox1.SelectedIndex;
            index--;
            if(index==0)
            {
                index = listSongs.Count - 1;
            }
            listBox1.SelectedIndex = index;
            sp.SoundLocation = listSongs[index];
            sp.Play();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            sp.Stop();
            sp.Dispose();
        }      
    }
}
