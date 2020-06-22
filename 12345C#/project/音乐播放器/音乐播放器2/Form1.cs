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

namespace 音乐播放器2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //在播放器加载时取消自动播放
            musicPlayer.settings.autoStart = false;

            label1.Image = Image.FromFile(@"D:\12345C#\project\音乐播放器\放音.jpg");

            //btn_playPause.Enabled = false;
            //musicPlayer.URL = @"D:\12345C#\WAV\WAV\song.wav";
            
        }

        private void play_Click(object sender, EventArgs e)
        {

            musicPlayer.Ctlcontrols.play();
        }

       

        private void stop_Click(object sender, EventArgs e)
        {
            musicPlayer.Ctlcontrols.stop();
        }

        private void pause_Click(object sender, EventArgs e)
        {
            musicPlayer.Ctlcontrols.pause();
        }


        bool selected = true;
        private void btn_playPause_Click(object sender, EventArgs e)
        {
            if(btn_playPause.Text=="播放")
            {
                //标记选中时播放
                if(selected)
                {
                    musicPlayer.URL = listPath[listBox1.SelectedIndex];
                }
                //正常的选中时播放
                musicPlayer.Ctlcontrols.play();
                btn_playPause.Text="暂停"; 
            }
            else
            {
                selected = false;
                musicPlayer.Ctlcontrols.pause();
                btn_playPause.Text = "播放";
            }
        }

        private void btn_stop_Click(object sender, EventArgs e)
        {
            musicPlayer.Ctlcontrols.stop();
            btn_playPause.Text = "播放";
        }

        List<string> listPath = new List<string>();
        
        private void btn_open_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.InitialDirectory = @"D:\12345C#\WAV\WAV";
            ofd.Filter = "音乐文件|*.wav|MP3文件|*.mp3|所有文件|*.*";
            ofd.Title = "请选择音乐文件";
            ofd.Multiselect = true;
            ofd.ShowDialog();

            //获得所选取的所有文件的全路径
            string[] paths = ofd.FileNames;

            
            for(int i=0;i<paths.Length;i++)
            {
                //将全路径保存在泛型集合当中
                listPath.Add(paths[i]);

                //将文件名添加到列表中
                listBox1.Items.Add(Path.GetFileName(paths[i]));
            }

        }

        /// <summary>
        /// 双击播放音乐
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>

        private void listBox1_DoubleClick(object sender, EventArgs e)
        {
            if (listBox1.Items.Count == 0)
            {
                MessageBox.Show("请先选择音乐文件");
                return;
            }
            try
            {
                musicPlayer.URL = listPath[listBox1.SelectedIndex];
                musicPlayer.Ctlcontrols.play();
                btn_playPause.Text = "暂停";
            }
            catch { }
        }

        private void btn_prew_Click(object sender, EventArgs e)
        {
            //获得当前列表中的选中项
            int index = listBox1.SelectedIndex;

            //清空当前选择项
            listBox1.SelectedIndices.Clear();

            index--;
            if (index < 0)   //到第一项
            {
                index = listPath.Count - 1;
            }
            listBox1.SelectedIndex = index;
            musicPlayer.URL = listPath[index];
            musicPlayer.Ctlcontrols.play();
            btn_playPause.Text = "暂停";
        }

        private void btn_next_Click(object sender, EventArgs e)
        {
            //获得当前列表中的选中项
            int index = listBox1.SelectedIndex;

            //清空当前选择项
            listBox1.SelectedIndices.Clear();

            index++;

            if (index == listPath.Count)   //超出索引，选择第一项
            {
                index = 0;
            }
            listBox1.SelectedIndex = index;
            musicPlayer.URL = listPath[index];
            musicPlayer.Ctlcontrols.play();
            btn_playPause.Text = "暂停";
        }

        /// <summary>
        /// 右键删除选中项
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //首先获得要删除的歌曲数量，然后一一删除
            int nCount = listBox1.SelectedItems.Count;
            for(int i=0;i<nCount;i++)
            {
                //先删除集合
                listPath.RemoveAt(listBox1.SelectedIndex);
                //再删除列表
                listBox1.Items.RemoveAt(listBox1.SelectedIndex);
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {
            if(label1.Tag.ToString()=="1")
            {
                musicPlayer.settings.mute = true;
                label1.Tag = 2;
                //显示静音的图片
                label1.Image = Image.FromFile(@"D:\12345C#\project\音乐播放器\静音.jpg");
            }
            else if(label1.Tag.ToString()=="2")
            {
                musicPlayer.settings.mute = false;
                label1.Tag = 1;
                //显示放音的图片
                label1.Image = Image.FromFile(@"D:\12345C#\project\音乐播放器\放音.jpg");
            }
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if(musicPlayer.playState== WMPLib.WMPPlayState.wmppsPlaying)
            {
                lb_info.Text = musicPlayer.currentMedia.duration.ToString() + "\r\n" +
                    musicPlayer.currentMedia.durationString + "\r\n" +
                    musicPlayer.Ctlcontrols.currentPosition.ToString() + "\r\n" +
                    musicPlayer.Ctlcontrols.currentPositionString;

                double d1 = double.Parse(musicPlayer.currentMedia.duration.ToString());
                double d2 = double.Parse(musicPlayer.Ctlcontrols.currentPosition.ToString())+1;
                if(d1<=d2)
                {
                    btn_next_Click(sender, e);
                }
            }
        }

    }
}
