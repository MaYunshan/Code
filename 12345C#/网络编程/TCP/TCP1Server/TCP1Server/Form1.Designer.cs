namespace TCP1Server
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
            this.rtxtRecv = new System.Windows.Forms.RichTextBox();
            this.rtxtSend = new System.Windows.Forms.RichTextBox();
            this.btnSend = new System.Windows.Forms.Button();
            this.btnClose = new System.Windows.Forms.Button();
            this.btnListen = new System.Windows.Forms.Button();
            this.cmb_Socket = new System.Windows.Forms.ComboBox();
            this.btnSelect = new System.Windows.Forms.Button();
            this.txtFileName = new System.Windows.Forms.TextBox();
            this.btnSendFile = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // rtxtRecv
            // 
            this.rtxtRecv.Location = new System.Drawing.Point(12, 66);
            this.rtxtRecv.Name = "rtxtRecv";
            this.rtxtRecv.Size = new System.Drawing.Size(322, 120);
            this.rtxtRecv.TabIndex = 0;
            this.rtxtRecv.Text = "";
            // 
            // rtxtSend
            // 
            this.rtxtSend.Location = new System.Drawing.Point(12, 192);
            this.rtxtSend.Name = "rtxtSend";
            this.rtxtSend.Size = new System.Drawing.Size(322, 110);
            this.rtxtSend.TabIndex = 0;
            this.rtxtSend.Text = "";
            // 
            // btnSend
            // 
            this.btnSend.Location = new System.Drawing.Point(12, 345);
            this.btnSend.Name = "btnSend";
            this.btnSend.Size = new System.Drawing.Size(75, 23);
            this.btnSend.TabIndex = 1;
            this.btnSend.Text = "发送信息";
            this.btnSend.UseVisualStyleBackColor = true;
            this.btnSend.Click += new System.EventHandler(this.btnSend_Click);
            // 
            // btnClose
            // 
            this.btnClose.Location = new System.Drawing.Point(258, 345);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(75, 23);
            this.btnClose.TabIndex = 1;
            this.btnClose.Text = "关闭";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // btnListen
            // 
            this.btnListen.Location = new System.Drawing.Point(12, 29);
            this.btnListen.Name = "btnListen";
            this.btnListen.Size = new System.Drawing.Size(75, 23);
            this.btnListen.TabIndex = 2;
            this.btnListen.Text = "开始监听";
            this.btnListen.UseVisualStyleBackColor = true;
            this.btnListen.Click += new System.EventHandler(this.btnListen_Click);
            // 
            // cmb_Socket
            // 
            this.cmb_Socket.FormattingEnabled = true;
            this.cmb_Socket.Location = new System.Drawing.Point(94, 32);
            this.cmb_Socket.Name = "cmb_Socket";
            this.cmb_Socket.Size = new System.Drawing.Size(238, 20);
            this.cmb_Socket.TabIndex = 3;
            // 
            // btnSelect
            // 
            this.btnSelect.Location = new System.Drawing.Point(257, 309);
            this.btnSelect.Name = "btnSelect";
            this.btnSelect.Size = new System.Drawing.Size(75, 23);
            this.btnSelect.TabIndex = 4;
            this.btnSelect.Text = "选择文件";
            this.btnSelect.UseVisualStyleBackColor = true;
            this.btnSelect.Click += new System.EventHandler(this.btnSelect_Click);
            // 
            // txtFileName
            // 
            this.txtFileName.Location = new System.Drawing.Point(12, 309);
            this.txtFileName.Name = "txtFileName";
            this.txtFileName.Size = new System.Drawing.Size(239, 21);
            this.txtFileName.TabIndex = 5;
            // 
            // btnSendFile
            // 
            this.btnSendFile.Location = new System.Drawing.Point(135, 345);
            this.btnSendFile.Name = "btnSendFile";
            this.btnSendFile.Size = new System.Drawing.Size(75, 23);
            this.btnSendFile.TabIndex = 6;
            this.btnSendFile.Text = "发送文件";
            this.btnSendFile.UseVisualStyleBackColor = true;
            this.btnSendFile.Click += new System.EventHandler(this.btnSendFile_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(349, 379);
            this.Controls.Add(this.btnSendFile);
            this.Controls.Add(this.txtFileName);
            this.Controls.Add(this.btnSelect);
            this.Controls.Add(this.cmb_Socket);
            this.Controls.Add(this.btnListen);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.btnSend);
            this.Controls.Add(this.rtxtSend);
            this.Controls.Add(this.rtxtRecv);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RichTextBox rtxtRecv;
        private System.Windows.Forms.RichTextBox rtxtSend;
        private System.Windows.Forms.Button btnSend;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnListen;
        private System.Windows.Forms.ComboBox cmb_Socket;
        private System.Windows.Forms.Button btnSelect;
        private System.Windows.Forms.TextBox txtFileName;
        private System.Windows.Forms.Button btnSendFile;
    }
}

