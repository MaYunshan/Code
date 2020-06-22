namespace 串口
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
            this.cmb_port = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.rtxt_send = new System.Windows.Forms.RichTextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.rtxt_recv = new System.Windows.Forms.RichTextBox();
            this.btn_open = new System.Windows.Forms.Button();
            this.btn_send = new System.Windows.Forms.Button();
            this.btn_close = new System.Windows.Forms.Button();
            this.btn_quit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // cmb_port
            // 
            this.cmb_port.FormattingEnabled = true;
            this.cmb_port.Location = new System.Drawing.Point(375, 22);
            this.cmb_port.Name = "cmb_port";
            this.cmb_port.Size = new System.Drawing.Size(86, 20);
            this.cmb_port.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 55);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 1;
            this.label1.Text = "发送区";
            // 
            // rtxt_send
            // 
            this.rtxt_send.Location = new System.Drawing.Point(28, 70);
            this.rtxt_send.Name = "rtxt_send";
            this.rtxt_send.Size = new System.Drawing.Size(433, 140);
            this.rtxt_send.TabIndex = 2;
            this.rtxt_send.Text = "";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 226);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "接收区";
            // 
            // rtxt_recv
            // 
            this.rtxt_recv.Location = new System.Drawing.Point(28, 241);
            this.rtxt_recv.Name = "rtxt_recv";
            this.rtxt_recv.ReadOnly = true;
            this.rtxt_recv.Size = new System.Drawing.Size(433, 140);
            this.rtxt_recv.TabIndex = 2;
            this.rtxt_recv.Text = "";
            // 
            // btn_open
            // 
            this.btn_open.Location = new System.Drawing.Point(29, 402);
            this.btn_open.Name = "btn_open";
            this.btn_open.Size = new System.Drawing.Size(75, 23);
            this.btn_open.TabIndex = 3;
            this.btn_open.Text = "打开";
            this.btn_open.UseVisualStyleBackColor = true;
            this.btn_open.Click += new System.EventHandler(this.btn_open_Click);
            // 
            // btn_send
            // 
            this.btn_send.Location = new System.Drawing.Point(150, 402);
            this.btn_send.Name = "btn_send";
            this.btn_send.Size = new System.Drawing.Size(75, 23);
            this.btn_send.TabIndex = 3;
            this.btn_send.Text = "发送";
            this.btn_send.UseVisualStyleBackColor = true;
            this.btn_send.Click += new System.EventHandler(this.btn_send_Click);
            // 
            // btn_close
            // 
            this.btn_close.Location = new System.Drawing.Point(271, 402);
            this.btn_close.Name = "btn_close";
            this.btn_close.Size = new System.Drawing.Size(75, 23);
            this.btn_close.TabIndex = 3;
            this.btn_close.Text = "关闭";
            this.btn_close.UseVisualStyleBackColor = true;
            this.btn_close.Click += new System.EventHandler(this.btn_close_Click);
            // 
            // btn_quit
            // 
            this.btn_quit.Location = new System.Drawing.Point(392, 402);
            this.btn_quit.Name = "btn_quit";
            this.btn_quit.Size = new System.Drawing.Size(75, 23);
            this.btn_quit.TabIndex = 3;
            this.btn_quit.Text = "退出";
            this.btn_quit.UseVisualStyleBackColor = true;
            this.btn_quit.Click += new System.EventHandler(this.btn_quit_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(490, 437);
            this.Controls.Add(this.btn_quit);
            this.Controls.Add(this.btn_close);
            this.Controls.Add(this.btn_send);
            this.Controls.Add(this.btn_open);
            this.Controls.Add(this.rtxt_recv);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.rtxt_send);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.cmb_port);
            this.Name = "Form1";
            this.Text = "Form1";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox cmb_port;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.RichTextBox rtxt_send;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.RichTextBox rtxt_recv;
        private System.Windows.Forms.Button btn_open;
        private System.Windows.Forms.Button btn_send;
        private System.Windows.Forms.Button btn_close;
        private System.Windows.Forms.Button btn_quit;
    }
}

