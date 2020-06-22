namespace 音乐播放器2
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.musicPlayer = new AxWMPLib.AxWindowsMediaPlayer();
            this.play = new System.Windows.Forms.Button();
            this.pause = new System.Windows.Forms.Button();
            this.stop = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.btn_playPause = new System.Windows.Forms.Button();
            this.btn_open = new System.Windows.Forms.Button();
            this.btn_stop = new System.Windows.Forms.Button();
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.删除ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.btn_prew = new System.Windows.Forms.Button();
            this.btn_next = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.lb_info = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.musicPlayer)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.contextMenuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // musicPlayer
            // 
            this.musicPlayer.Enabled = true;
            this.musicPlayer.Location = new System.Drawing.Point(12, 12);
            this.musicPlayer.Name = "musicPlayer";
            this.musicPlayer.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("musicPlayer.OcxState")));
            this.musicPlayer.Size = new System.Drawing.Size(534, 280);
            this.musicPlayer.TabIndex = 0;
            // 
            // play
            // 
            this.play.Location = new System.Drawing.Point(23, 20);
            this.play.Name = "play";
            this.play.Size = new System.Drawing.Size(75, 23);
            this.play.TabIndex = 1;
            this.play.Text = "播放";
            this.play.UseVisualStyleBackColor = true;
            this.play.Click += new System.EventHandler(this.play_Click);
            // 
            // pause
            // 
            this.pause.Location = new System.Drawing.Point(23, 45);
            this.pause.Name = "pause";
            this.pause.Size = new System.Drawing.Size(75, 23);
            this.pause.TabIndex = 1;
            this.pause.Text = "暂停";
            this.pause.UseVisualStyleBackColor = true;
            this.pause.Click += new System.EventHandler(this.pause_Click);
            // 
            // stop
            // 
            this.stop.Location = new System.Drawing.Point(23, 71);
            this.stop.Name = "stop";
            this.stop.Size = new System.Drawing.Size(75, 23);
            this.stop.TabIndex = 1;
            this.stop.Text = "停止";
            this.stop.UseVisualStyleBackColor = true;
            this.stop.Click += new System.EventHandler(this.stop_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.play);
            this.groupBox1.Controls.Add(this.stop);
            this.groupBox1.Controls.Add(this.pause);
            this.groupBox1.Location = new System.Drawing.Point(565, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(117, 100);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "第一次";
            // 
            // btn_playPause
            // 
            this.btn_playPause.Location = new System.Drawing.Point(13, 311);
            this.btn_playPause.Name = "btn_playPause";
            this.btn_playPause.Size = new System.Drawing.Size(75, 23);
            this.btn_playPause.TabIndex = 3;
            this.btn_playPause.Text = "播放";
            this.btn_playPause.UseVisualStyleBackColor = true;
            this.btn_playPause.Click += new System.EventHandler(this.btn_playPause_Click);
            // 
            // btn_open
            // 
            this.btn_open.Location = new System.Drawing.Point(552, 348);
            this.btn_open.Name = "btn_open";
            this.btn_open.Size = new System.Drawing.Size(75, 23);
            this.btn_open.TabIndex = 4;
            this.btn_open.Text = "打开";
            this.btn_open.UseVisualStyleBackColor = true;
            this.btn_open.Click += new System.EventHandler(this.btn_open_Click);
            // 
            // btn_stop
            // 
            this.btn_stop.Location = new System.Drawing.Point(125, 311);
            this.btn_stop.Name = "btn_stop";
            this.btn_stop.Size = new System.Drawing.Size(75, 23);
            this.btn_stop.TabIndex = 5;
            this.btn_stop.Text = "停止";
            this.btn_stop.UseVisualStyleBackColor = true;
            this.btn_stop.Click += new System.EventHandler(this.btn_stop_Click);
            // 
            // listBox1
            // 
            this.listBox1.ContextMenuStrip = this.contextMenuStrip1;
            this.listBox1.FormattingEnabled = true;
            this.listBox1.ItemHeight = 12;
            this.listBox1.Location = new System.Drawing.Point(565, 118);
            this.listBox1.Name = "listBox1";
            this.listBox1.SelectionMode = System.Windows.Forms.SelectionMode.MultiExtended;
            this.listBox1.Size = new System.Drawing.Size(223, 220);
            this.listBox1.TabIndex = 6;
            this.listBox1.DoubleClick += new System.EventHandler(this.listBox1_DoubleClick);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.删除ToolStripMenuItem});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(101, 26);
            // 
            // 删除ToolStripMenuItem
            // 
            this.删除ToolStripMenuItem.Name = "删除ToolStripMenuItem";
            this.删除ToolStripMenuItem.Size = new System.Drawing.Size(100, 22);
            this.删除ToolStripMenuItem.Text = "删除";
            this.删除ToolStripMenuItem.Click += new System.EventHandler(this.删除ToolStripMenuItem_Click);
            // 
            // btn_prew
            // 
            this.btn_prew.Location = new System.Drawing.Point(235, 311);
            this.btn_prew.Name = "btn_prew";
            this.btn_prew.Size = new System.Drawing.Size(75, 23);
            this.btn_prew.TabIndex = 7;
            this.btn_prew.Text = "上一曲";
            this.btn_prew.UseVisualStyleBackColor = true;
            this.btn_prew.Click += new System.EventHandler(this.btn_prew_Click);
            // 
            // btn_next
            // 
            this.btn_next.Location = new System.Drawing.Point(348, 311);
            this.btn_next.Name = "btn_next";
            this.btn_next.Size = new System.Drawing.Size(75, 23);
            this.btn_next.TabIndex = 7;
            this.btn_next.Text = "下一曲";
            this.btn_next.UseVisualStyleBackColor = true;
            this.btn_next.Click += new System.EventHandler(this.btn_next_Click);
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(348, 348);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(93, 79);
            this.label1.TabIndex = 8;
            this.label1.Tag = "1";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // lb_info
            // 
            this.lb_info.AutoSize = true;
            this.lb_info.Location = new System.Drawing.Point(13, 358);
            this.lb_info.Name = "lb_info";
            this.lb_info.Size = new System.Drawing.Size(0, 12);
            this.lb_info.TabIndex = 9;
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 480);
            this.Controls.Add(this.lb_info);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btn_next);
            this.Controls.Add(this.btn_prew);
            this.Controls.Add(this.listBox1);
            this.Controls.Add(this.btn_stop);
            this.Controls.Add(this.btn_open);
            this.Controls.Add(this.btn_playPause);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.musicPlayer);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.musicPlayer)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.contextMenuStrip1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private AxWMPLib.AxWindowsMediaPlayer musicPlayer;
        private System.Windows.Forms.Button play;
        private System.Windows.Forms.Button pause;
        private System.Windows.Forms.Button stop;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button btn_playPause;
        private System.Windows.Forms.Button btn_open;
        private System.Windows.Forms.Button btn_stop;
        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.Button btn_prew;
        private System.Windows.Forms.Button btn_next;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem 删除ToolStripMenuItem;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lb_info;
        private System.Windows.Forms.Timer timer1;
    }
}

