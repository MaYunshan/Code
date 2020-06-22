namespace 串口1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btn_openPort = new System.Windows.Forms.Button();
            this.cmb_stopBit = new System.Windows.Forms.ComboBox();
            this.cmb_dataBit = new System.Windows.Forms.ComboBox();
            this.cmb_checkBit = new System.Windows.Forms.ComboBox();
            this.cmb_baud = new System.Windows.Forms.ComboBox();
            this.cmb_port = new System.Windows.Forms.ComboBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.btn_clearDis = new System.Windows.Forms.Button();
            this.chb_pause = new System.Windows.Forms.CheckBox();
            this.btn_saveData = new System.Windows.Forms.Button();
            this.chb_time = new System.Windows.Forms.CheckBox();
            this.chb_toHexRecv = new System.Windows.Forms.CheckBox();
            this.chb_toFile = new System.Windows.Forms.CheckBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.chb_loopSend = new System.Windows.Forms.CheckBox();
            this.btn_clearInput = new System.Windows.Forms.Button();
            this.txt_period = new System.Windows.Forms.TextBox();
            this.btn_loadData = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.chb_sendFile = new System.Windows.Forms.CheckBox();
            this.chb_toHexSend = new System.Windows.Forms.CheckBox();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.rtxt_recv = new System.Windows.Forms.RichTextBox();
            this.rtxt_send = new System.Windows.Forms.RichTextBox();
            this.btn_send = new System.Windows.Forms.Button();
            this.lab_sendCount = new System.Windows.Forms.Label();
            this.lab__recvCount = new System.Windows.Forms.Label();
            this.btn_sendCountReset = new System.Windows.Forms.Button();
            this.btn_recvCountReset = new System.Windows.Forms.Button();
            this.btn_help = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.pictureBox1);
            this.groupBox1.Controls.Add(this.btn_openPort);
            this.groupBox1.Controls.Add(this.cmb_stopBit);
            this.groupBox1.Controls.Add(this.cmb_dataBit);
            this.groupBox1.Controls.Add(this.cmb_checkBit);
            this.groupBox1.Controls.Add(this.cmb_baud);
            this.groupBox1.Controls.Add(this.cmb_port);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.groupBox1.Location = new System.Drawing.Point(3, 2);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(140, 180);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "串口设置";
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.Color.Red;
            this.pictureBox1.Location = new System.Drawing.Point(11, 148);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(20, 23);
            this.pictureBox1.TabIndex = 3;
            this.pictureBox1.TabStop = false;
            // 
            // btn_openPort
            // 
            this.btn_openPort.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_openPort.Location = new System.Drawing.Point(57, 148);
            this.btn_openPort.Name = "btn_openPort";
            this.btn_openPort.Size = new System.Drawing.Size(72, 23);
            this.btn_openPort.TabIndex = 2;
            this.btn_openPort.Text = "打开";
            this.btn_openPort.UseVisualStyleBackColor = true;
            this.btn_openPort.Click += new System.EventHandler(this.btn_openPort_Click);
            // 
            // cmb_stopBit
            // 
            this.cmb_stopBit.FormattingEnabled = true;
            this.cmb_stopBit.Items.AddRange(new object[] {
            "1",
            "2"});
            this.cmb_stopBit.Location = new System.Drawing.Point(57, 122);
            this.cmb_stopBit.Name = "cmb_stopBit";
            this.cmb_stopBit.Size = new System.Drawing.Size(72, 20);
            this.cmb_stopBit.TabIndex = 1;
            this.cmb_stopBit.Text = "1";
            this.cmb_stopBit.SelectedIndexChanged += new System.EventHandler(this.cmb_stopBit_SelectedIndexChanged);
            // 
            // cmb_dataBit
            // 
            this.cmb_dataBit.FormattingEnabled = true;
            this.cmb_dataBit.Items.AddRange(new object[] {
            "5",
            "6",
            "7",
            "8"});
            this.cmb_dataBit.Location = new System.Drawing.Point(57, 95);
            this.cmb_dataBit.Name = "cmb_dataBit";
            this.cmb_dataBit.Size = new System.Drawing.Size(72, 20);
            this.cmb_dataBit.TabIndex = 1;
            this.cmb_dataBit.Text = "8";
            this.cmb_dataBit.SelectedIndexChanged += new System.EventHandler(this.cmb_dataBit_SelectedIndexChanged);
            // 
            // cmb_checkBit
            // 
            this.cmb_checkBit.FormattingEnabled = true;
            this.cmb_checkBit.Items.AddRange(new object[] {
            "NONE",
            "ODD",
            "EVEN",
            "MARK",
            "SPACE"});
            this.cmb_checkBit.Location = new System.Drawing.Point(57, 68);
            this.cmb_checkBit.Name = "cmb_checkBit";
            this.cmb_checkBit.Size = new System.Drawing.Size(72, 20);
            this.cmb_checkBit.TabIndex = 1;
            this.cmb_checkBit.Text = "NONE";
            this.cmb_checkBit.SelectedIndexChanged += new System.EventHandler(this.cmb_checkBit_SelectedIndexChanged);
            // 
            // cmb_baud
            // 
            this.cmb_baud.FormattingEnabled = true;
            this.cmb_baud.Items.AddRange(new object[] {
            "300",
            "600",
            "1200",
            "2400",
            "4800",
            "9600",
            "14400",
            "19200",
            "38400",
            "56000",
            "57600",
            "115200",
            "128000",
            "256000"});
            this.cmb_baud.Location = new System.Drawing.Point(57, 41);
            this.cmb_baud.Name = "cmb_baud";
            this.cmb_baud.Size = new System.Drawing.Size(72, 20);
            this.cmb_baud.TabIndex = 1;
            this.cmb_baud.Text = "9600";
            this.cmb_baud.SelectedIndexChanged += new System.EventHandler(this.cmb_baud_SelectedIndexChanged);
            // 
            // cmb_port
            // 
            this.cmb_port.FormattingEnabled = true;
            this.cmb_port.Location = new System.Drawing.Point(57, 15);
            this.cmb_port.Name = "cmb_port";
            this.cmb_port.Size = new System.Drawing.Size(72, 20);
            this.cmb_port.TabIndex = 1;
            this.cmb_port.SelectedIndexChanged += new System.EventHandler(this.cmb_port_SelectedIndexChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(3, 125);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(41, 12);
            this.label5.TabIndex = 0;
            this.label5.Text = "停止位";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(3, 98);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(41, 12);
            this.label4.TabIndex = 0;
            this.label4.Text = "数据位";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(3, 71);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(41, 12);
            this.label3.TabIndex = 0;
            this.label3.Text = "检验位";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(3, 44);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 0;
            this.label2.Text = "波特率";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Location = new System.Drawing.Point(9, 18);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(29, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "端口";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.btn_clearDis);
            this.groupBox2.Controls.Add(this.chb_pause);
            this.groupBox2.Controls.Add(this.btn_saveData);
            this.groupBox2.Controls.Add(this.chb_time);
            this.groupBox2.Controls.Add(this.chb_toHexRecv);
            this.groupBox2.Controls.Add(this.chb_toFile);
            this.groupBox2.Location = new System.Drawing.Point(3, 189);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(140, 126);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "接收设置";
            // 
            // btn_clearDis
            // 
            this.btn_clearDis.FlatAppearance.BorderSize = 0;
            this.btn_clearDis.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_clearDis.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btn_clearDis.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btn_clearDis.Location = new System.Drawing.Point(71, 103);
            this.btn_clearDis.Name = "btn_clearDis";
            this.btn_clearDis.Size = new System.Drawing.Size(65, 20);
            this.btn_clearDis.TabIndex = 1;
            this.btn_clearDis.Text = "清除显示";
            this.btn_clearDis.UseVisualStyleBackColor = true;
            this.btn_clearDis.Click += new System.EventHandler(this.btn_clearDis_Click);
            this.btn_clearDis.MouseEnter += new System.EventHandler(this.btn_clearDis_MouseEnter);
            this.btn_clearDis.MouseLeave += new System.EventHandler(this.btn_clearDis_MouseLeave);
            // 
            // chb_pause
            // 
            this.chb_pause.AutoSize = true;
            this.chb_pause.Location = new System.Drawing.Point(22, 86);
            this.chb_pause.Name = "chb_pause";
            this.chb_pause.Size = new System.Drawing.Size(96, 16);
            this.chb_pause.TabIndex = 0;
            this.chb_pause.Text = "暂停数据接收";
            this.chb_pause.UseVisualStyleBackColor = true;
            this.chb_pause.Click += new System.EventHandler(this.chb_pause_Click);
            // 
            // btn_saveData
            // 
            this.btn_saveData.FlatAppearance.BorderSize = 0;
            this.btn_saveData.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_saveData.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btn_saveData.ForeColor = System.Drawing.SystemColors.Highlight;
            this.btn_saveData.Location = new System.Drawing.Point(5, 103);
            this.btn_saveData.Name = "btn_saveData";
            this.btn_saveData.Size = new System.Drawing.Size(65, 20);
            this.btn_saveData.TabIndex = 1;
            this.btn_saveData.Text = "保存数据";
            this.btn_saveData.UseVisualStyleBackColor = true;
            this.btn_saveData.Click += new System.EventHandler(this.btn_saveData_Click);
            this.btn_saveData.MouseEnter += new System.EventHandler(this.btn_saveData_MouseEnter);
            this.btn_saveData.MouseLeave += new System.EventHandler(this.btn_saveData_MouseLeave);
            // 
            // chb_time
            // 
            this.chb_time.AutoSize = true;
            this.chb_time.Location = new System.Drawing.Point(22, 64);
            this.chb_time.Name = "chb_time";
            this.chb_time.Size = new System.Drawing.Size(96, 16);
            this.chb_time.TabIndex = 0;
            this.chb_time.Text = "显示接收时间";
            this.chb_time.UseVisualStyleBackColor = true;
            // 
            // chb_toHexRecv
            // 
            this.chb_toHexRecv.AutoSize = true;
            this.chb_toHexRecv.Location = new System.Drawing.Point(22, 42);
            this.chb_toHexRecv.Name = "chb_toHexRecv";
            this.chb_toHexRecv.Size = new System.Drawing.Size(96, 16);
            this.chb_toHexRecv.TabIndex = 0;
            this.chb_toHexRecv.Text = "十六进制显示";
            this.chb_toHexRecv.UseVisualStyleBackColor = true;
            // 
            // chb_toFile
            // 
            this.chb_toFile.AutoSize = true;
            this.chb_toFile.Location = new System.Drawing.Point(22, 20);
            this.chb_toFile.Name = "chb_toFile";
            this.chb_toFile.Size = new System.Drawing.Size(96, 16);
            this.chb_toFile.TabIndex = 0;
            this.chb_toFile.Text = "接收转向文件";
            this.chb_toFile.UseVisualStyleBackColor = true;
            this.chb_toFile.Click += new System.EventHandler(this.chb_toFile_Click);
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.chb_loopSend);
            this.groupBox3.Controls.Add(this.btn_clearInput);
            this.groupBox3.Controls.Add(this.txt_period);
            this.groupBox3.Controls.Add(this.btn_loadData);
            this.groupBox3.Controls.Add(this.label7);
            this.groupBox3.Controls.Add(this.label6);
            this.groupBox3.Controls.Add(this.chb_sendFile);
            this.groupBox3.Controls.Add(this.chb_toHexSend);
            this.groupBox3.Location = new System.Drawing.Point(3, 318);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(140, 146);
            this.groupBox3.TabIndex = 1;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "发送设置";
            // 
            // chb_loopSend
            // 
            this.chb_loopSend.AutoSize = true;
            this.chb_loopSend.Location = new System.Drawing.Point(22, 64);
            this.chb_loopSend.Name = "chb_loopSend";
            this.chb_loopSend.Size = new System.Drawing.Size(96, 16);
            this.chb_loopSend.TabIndex = 5;
            this.chb_loopSend.Text = "数据循环发送";
            this.chb_loopSend.UseVisualStyleBackColor = true;
            this.chb_loopSend.Click += new System.EventHandler(this.chb_loopSend_Click);
            // 
            // btn_clearInput
            // 
            this.btn_clearInput.FlatAppearance.BorderSize = 0;
            this.btn_clearInput.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_clearInput.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btn_clearInput.ForeColor = System.Drawing.SystemColors.Highlight;
            this.btn_clearInput.Location = new System.Drawing.Point(71, 114);
            this.btn_clearInput.Name = "btn_clearInput";
            this.btn_clearInput.Size = new System.Drawing.Size(65, 20);
            this.btn_clearInput.TabIndex = 1;
            this.btn_clearInput.Text = "清除输入";
            this.btn_clearInput.UseVisualStyleBackColor = true;
            this.btn_clearInput.Click += new System.EventHandler(this.btn_clearInput_Click);
            this.btn_clearInput.MouseEnter += new System.EventHandler(this.btn_clearInput_MouseEnter);
            this.btn_clearInput.MouseLeave += new System.EventHandler(this.btn_clearInput_MouseLeave);
            // 
            // txt_period
            // 
            this.txt_period.Location = new System.Drawing.Point(57, 87);
            this.txt_period.Name = "txt_period";
            this.txt_period.Size = new System.Drawing.Size(38, 21);
            this.txt_period.TabIndex = 4;
            this.txt_period.Text = "1000";
            // 
            // btn_loadData
            // 
            this.btn_loadData.FlatAppearance.BorderSize = 0;
            this.btn_loadData.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_loadData.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btn_loadData.ForeColor = System.Drawing.SystemColors.Highlight;
            this.btn_loadData.Location = new System.Drawing.Point(5, 114);
            this.btn_loadData.Name = "btn_loadData";
            this.btn_loadData.Size = new System.Drawing.Size(65, 20);
            this.btn_loadData.TabIndex = 1;
            this.btn_loadData.Text = "载入数据";
            this.btn_loadData.UseVisualStyleBackColor = true;
            this.btn_loadData.Click += new System.EventHandler(this.btn_loadData_Click);
            this.btn_loadData.MouseEnter += new System.EventHandler(this.btn_loadData_MouseEnter);
            this.btn_loadData.MouseLeave += new System.EventHandler(this.btn_loadData_MouseLeave);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(101, 90);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(29, 12);
            this.label7.TabIndex = 3;
            this.label7.Text = "毫秒";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(-3, 90);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(53, 12);
            this.label6.TabIndex = 3;
            this.label6.Text = "发送间隔";
            // 
            // chb_sendFile
            // 
            this.chb_sendFile.AutoSize = true;
            this.chb_sendFile.Location = new System.Drawing.Point(22, 20);
            this.chb_sendFile.Name = "chb_sendFile";
            this.chb_sendFile.Size = new System.Drawing.Size(96, 16);
            this.chb_sendFile.TabIndex = 2;
            this.chb_sendFile.Text = "发送文件数据";
            this.chb_sendFile.UseVisualStyleBackColor = true;
            this.chb_sendFile.Click += new System.EventHandler(this.chb_sendFile_Click);
            // 
            // chb_toHexSend
            // 
            this.chb_toHexSend.AutoSize = true;
            this.chb_toHexSend.Location = new System.Drawing.Point(22, 42);
            this.chb_toHexSend.Name = "chb_toHexSend";
            this.chb_toHexSend.Size = new System.Drawing.Size(96, 16);
            this.chb_toHexSend.TabIndex = 1;
            this.chb_toHexSend.Text = "十六进制发送";
            this.chb_toHexSend.UseVisualStyleBackColor = true;
            this.chb_toHexSend.Click += new System.EventHandler(this.chb_toHexSend_Click);
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.rtxt_recv);
            this.groupBox4.Location = new System.Drawing.Point(150, 2);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(407, 374);
            this.groupBox4.TabIndex = 4;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "串口数据接收";
            // 
            // rtxt_recv
            // 
            this.rtxt_recv.Location = new System.Drawing.Point(7, 15);
            this.rtxt_recv.Name = "rtxt_recv";
            this.rtxt_recv.Size = new System.Drawing.Size(400, 359);
            this.rtxt_recv.TabIndex = 0;
            this.rtxt_recv.Text = "";
            // 
            // rtxt_send
            // 
            this.rtxt_send.Location = new System.Drawing.Point(157, 380);
            this.rtxt_send.Name = "rtxt_send";
            this.rtxt_send.Size = new System.Drawing.Size(332, 57);
            this.rtxt_send.TabIndex = 5;
            this.rtxt_send.Text = "";
            // 
            // btn_send
            // 
            this.btn_send.Location = new System.Drawing.Point(495, 380);
            this.btn_send.Name = "btn_send";
            this.btn_send.Size = new System.Drawing.Size(62, 57);
            this.btn_send.TabIndex = 6;
            this.btn_send.Text = "发送";
            this.btn_send.UseVisualStyleBackColor = true;
            this.btn_send.Click += new System.EventHandler(this.btn_send_Click);
            // 
            // lab_sendCount
            // 
            this.lab_sendCount.AutoSize = true;
            this.lab_sendCount.Location = new System.Drawing.Point(345, 445);
            this.lab_sendCount.Name = "lab_sendCount";
            this.lab_sendCount.Size = new System.Drawing.Size(47, 12);
            this.lab_sendCount.TabIndex = 7;
            this.lab_sendCount.Text = "发送：0";
            // 
            // lab__recvCount
            // 
            this.lab__recvCount.AutoSize = true;
            this.lab__recvCount.Location = new System.Drawing.Point(419, 445);
            this.lab__recvCount.Name = "lab__recvCount";
            this.lab__recvCount.Size = new System.Drawing.Size(47, 12);
            this.lab__recvCount.TabIndex = 7;
            this.lab__recvCount.Text = "接收：0";
            // 
            // btn_sendCountReset
            // 
            this.btn_sendCountReset.Location = new System.Drawing.Point(274, 441);
            this.btn_sendCountReset.Name = "btn_sendCountReset";
            this.btn_sendCountReset.Size = new System.Drawing.Size(65, 20);
            this.btn_sendCountReset.TabIndex = 8;
            this.btn_sendCountReset.Text = "发送复位";
            this.btn_sendCountReset.UseVisualStyleBackColor = true;
            this.btn_sendCountReset.Click += new System.EventHandler(this.btn_sendCountReset_Click);
            // 
            // btn_recvCountReset
            // 
            this.btn_recvCountReset.Location = new System.Drawing.Point(489, 441);
            this.btn_recvCountReset.Name = "btn_recvCountReset";
            this.btn_recvCountReset.Size = new System.Drawing.Size(65, 20);
            this.btn_recvCountReset.TabIndex = 8;
            this.btn_recvCountReset.Text = "接收复位";
            this.btn_recvCountReset.UseVisualStyleBackColor = true;
            this.btn_recvCountReset.Click += new System.EventHandler(this.btn_recvCountReset_Click);
            // 
            // btn_help
            // 
            this.btn_help.Location = new System.Drawing.Point(157, 441);
            this.btn_help.Name = "btn_help";
            this.btn_help.Size = new System.Drawing.Size(65, 20);
            this.btn_help.TabIndex = 9;
            this.btn_help.Text = "帮助";
            this.btn_help.UseVisualStyleBackColor = true;
            this.btn_help.Click += new System.EventHandler(this.btn_help_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(558, 466);
            this.Controls.Add(this.btn_help);
            this.Controls.Add(this.btn_recvCountReset);
            this.Controls.Add(this.btn_sendCountReset);
            this.Controls.Add(this.lab__recvCount);
            this.Controls.Add(this.lab_sendCount);
            this.Controls.Add(this.btn_send);
            this.Controls.Add(this.rtxt_send);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form1";
            this.Text = "串口调试助手";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox4.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button btn_openPort;
        private System.Windows.Forms.ComboBox cmb_stopBit;
        private System.Windows.Forms.ComboBox cmb_dataBit;
        private System.Windows.Forms.ComboBox cmb_checkBit;
        private System.Windows.Forms.ComboBox cmb_baud;
        private System.Windows.Forms.ComboBox cmb_port;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button btn_clearDis;
        private System.Windows.Forms.CheckBox chb_pause;
        private System.Windows.Forms.Button btn_saveData;
        private System.Windows.Forms.CheckBox chb_time;
        private System.Windows.Forms.CheckBox chb_toHexRecv;
        private System.Windows.Forms.CheckBox chb_toFile;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button btn_clearInput;
        private System.Windows.Forms.TextBox txt_period;
        private System.Windows.Forms.Button btn_loadData;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.CheckBox chb_sendFile;
        private System.Windows.Forms.CheckBox chb_toHexSend;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.RichTextBox rtxt_recv;
        private System.Windows.Forms.RichTextBox rtxt_send;
        private System.Windows.Forms.Button btn_send;
        private System.Windows.Forms.Label lab_sendCount;
        private System.Windows.Forms.Label lab__recvCount;
        private System.Windows.Forms.Button btn_sendCountReset;
        private System.Windows.Forms.Button btn_recvCountReset;
        private System.Windows.Forms.CheckBox chb_loopSend;
        private System.Windows.Forms.Button btn_help;
    }
}

