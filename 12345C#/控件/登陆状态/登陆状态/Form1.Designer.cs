namespace 登陆状态
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
            this.imageList1 = new System.Windows.Forms.ImageList(this.components);
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.btnSure = new System.Windows.Forms.Button();
            this.btnQuit = new System.Windows.Forms.Button();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtPass = new System.Windows.Forms.TextBox();
            this.txtPhone = new System.Windows.Forms.TextBox();
            this.txtMail = new System.Windows.Forms.TextBox();
            this.txtAddress = new System.Windows.Forms.TextBox();
            this.ckInfo = new System.Windows.Forms.CheckBox();
            this.ckSell = new System.Windows.Forms.CheckBox();
            this.ckMange = new System.Windows.Forms.CheckBox();
            this.ckShop = new System.Windows.Forms.CheckBox();
            this.ckLInfo = new System.Windows.Forms.CheckedListBox();
            this.ckLShop = new System.Windows.Forms.CheckedListBox();
            this.ckLSell = new System.Windows.Forms.CheckedListBox();
            this.ckLMange = new System.Windows.Forms.CheckedListBox();
            this.radMan = new System.Windows.Forms.RadioButton();
            this.radWoman = new System.Windows.Forms.RadioButton();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // imageList1
            // 
            this.imageList1.ColorDepth = System.Windows.Forms.ColorDepth.Depth8Bit;
            this.imageList1.ImageSize = new System.Drawing.Size(16, 16);
            this.imageList1.TransparentColor = System.Drawing.Color.Transparent;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radWoman);
            this.groupBox1.Controls.Add(this.radMan);
            this.groupBox1.Controls.Add(this.txtAddress);
            this.groupBox1.Controls.Add(this.txtMail);
            this.groupBox1.Controls.Add(this.txtPhone);
            this.groupBox1.Controls.Add(this.txtPass);
            this.groupBox1.Controls.Add(this.txtName);
            this.groupBox1.Controls.Add(this.btnQuit);
            this.groupBox1.Controls.Add(this.btnSure);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(2, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(191, 287);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "用户注册";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.ckLMange);
            this.groupBox2.Controls.Add(this.ckLSell);
            this.groupBox2.Controls.Add(this.ckLShop);
            this.groupBox2.Controls.Add(this.ckLInfo);
            this.groupBox2.Controls.Add(this.ckShop);
            this.groupBox2.Controls.Add(this.ckMange);
            this.groupBox2.Controls.Add(this.ckSell);
            this.groupBox2.Controls.Add(this.ckInfo);
            this.groupBox2.Location = new System.Drawing.Point(199, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(157, 287);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "用户权限";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(10, 30);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "姓名：";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(10, 66);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "密码：";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(10, 100);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(41, 12);
            this.label3.TabIndex = 2;
            this.label3.Text = "电话：";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(10, 137);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(41, 12);
            this.label4.TabIndex = 3;
            this.label4.Text = "邮箱：";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(10, 175);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(41, 12);
            this.label5.TabIndex = 4;
            this.label5.Text = "地址：";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(10, 211);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(41, 12);
            this.label6.TabIndex = 5;
            this.label6.Text = "性别：";
            // 
            // btnSure
            // 
            this.btnSure.Location = new System.Drawing.Point(6, 245);
            this.btnSure.Name = "btnSure";
            this.btnSure.Size = new System.Drawing.Size(75, 23);
            this.btnSure.TabIndex = 6;
            this.btnSure.Text = "确定(&D)";
            this.btnSure.UseVisualStyleBackColor = true;
            this.btnSure.Click += new System.EventHandler(this.btnSure_Click);
            // 
            // btnQuit
            // 
            this.btnQuit.Location = new System.Drawing.Point(100, 245);
            this.btnQuit.Name = "btnQuit";
            this.btnQuit.Size = new System.Drawing.Size(75, 23);
            this.btnQuit.TabIndex = 7;
            this.btnQuit.Text = "取消(&E)";
            this.btnQuit.UseVisualStyleBackColor = true;
            this.btnQuit.Click += new System.EventHandler(this.btnQuit_Click);
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(75, 27);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(100, 21);
            this.txtName.TabIndex = 8;
            // 
            // txtPass
            // 
            this.txtPass.Location = new System.Drawing.Point(75, 63);
            this.txtPass.Name = "txtPass";
            this.txtPass.Size = new System.Drawing.Size(100, 21);
            this.txtPass.TabIndex = 9;
            // 
            // txtPhone
            // 
            this.txtPhone.Location = new System.Drawing.Point(75, 97);
            this.txtPhone.Name = "txtPhone";
            this.txtPhone.Size = new System.Drawing.Size(100, 21);
            this.txtPhone.TabIndex = 10;
            // 
            // txtMail
            // 
            this.txtMail.Location = new System.Drawing.Point(75, 134);
            this.txtMail.Name = "txtMail";
            this.txtMail.Size = new System.Drawing.Size(100, 21);
            this.txtMail.TabIndex = 11;
            // 
            // txtAddress
            // 
            this.txtAddress.Location = new System.Drawing.Point(75, 166);
            this.txtAddress.Name = "txtAddress";
            this.txtAddress.Size = new System.Drawing.Size(100, 21);
            this.txtAddress.TabIndex = 12;
            // 
            // ckInfo
            // 
            this.ckInfo.AutoSize = true;
            this.ckInfo.Location = new System.Drawing.Point(24, 20);
            this.ckInfo.Name = "ckInfo";
            this.ckInfo.Size = new System.Drawing.Size(72, 16);
            this.ckInfo.TabIndex = 0;
            this.ckInfo.Text = "基本档案";
            this.ckInfo.UseVisualStyleBackColor = true;
            this.ckInfo.CheckedChanged += new System.EventHandler(this.ckInfo_CheckedChanged);
            // 
            // ckSell
            // 
            this.ckSell.AutoSize = true;
            this.ckSell.Location = new System.Drawing.Point(24, 153);
            this.ckSell.Name = "ckSell";
            this.ckSell.Size = new System.Drawing.Size(72, 16);
            this.ckSell.TabIndex = 1;
            this.ckSell.Text = "销售管理";
            this.ckSell.UseVisualStyleBackColor = true;
            this.ckSell.CheckedChanged += new System.EventHandler(this.ckSell_CheckedChanged);
            // 
            // ckMange
            // 
            this.ckMange.AutoSize = true;
            this.ckMange.Location = new System.Drawing.Point(24, 217);
            this.ckMange.Name = "ckMange";
            this.ckMange.Size = new System.Drawing.Size(72, 16);
            this.ckMange.TabIndex = 2;
            this.ckMange.Text = "库存管理";
            this.ckMange.UseVisualStyleBackColor = true;
            this.ckMange.CheckedChanged += new System.EventHandler(this.ckMange_CheckedChanged);
            // 
            // ckShop
            // 
            this.ckShop.AutoSize = true;
            this.ckShop.Location = new System.Drawing.Point(24, 96);
            this.ckShop.Name = "ckShop";
            this.ckShop.Size = new System.Drawing.Size(72, 16);
            this.ckShop.TabIndex = 3;
            this.ckShop.Text = "进货管理";
            this.ckShop.UseVisualStyleBackColor = true;
            this.ckShop.CheckedChanged += new System.EventHandler(this.ckShop_CheckedChanged);
            // 
            // ckLInfo
            // 
            this.ckLInfo.FormattingEnabled = true;
            this.ckLInfo.Items.AddRange(new object[] {
            "员工信息",
            "往来单位",
            "客户档案"});
            this.ckLInfo.Location = new System.Drawing.Point(40, 38);
            this.ckLInfo.Name = "ckLInfo";
            this.ckLInfo.Size = new System.Drawing.Size(88, 52);
            this.ckLInfo.TabIndex = 4;
            this.ckLInfo.Visible = false;
            // 
            // ckLShop
            // 
            this.ckLShop.FormattingEnabled = true;
            this.ckLShop.Items.AddRange(new object[] {
            "采购进货",
            "采购退货"});
            this.ckLShop.Location = new System.Drawing.Point(40, 114);
            this.ckLShop.Name = "ckLShop";
            this.ckLShop.Size = new System.Drawing.Size(88, 36);
            this.ckLShop.TabIndex = 5;
            this.ckLShop.Visible = false;
            // 
            // ckLSell
            // 
            this.ckLSell.FormattingEnabled = true;
            this.ckLSell.Items.AddRange(new object[] {
            "商品销售",
            "客户退货"});
            this.ckLSell.Location = new System.Drawing.Point(40, 175);
            this.ckLSell.Name = "ckLSell";
            this.ckLSell.Size = new System.Drawing.Size(88, 36);
            this.ckLSell.TabIndex = 6;
            this.ckLSell.Visible = false;
            // 
            // ckLMange
            // 
            this.ckLMange.FormattingEnabled = true;
            this.ckLMange.Items.AddRange(new object[] {
            "库存调配",
            "库存警报"});
            this.ckLMange.Location = new System.Drawing.Point(40, 239);
            this.ckLMange.Name = "ckLMange";
            this.ckLMange.Size = new System.Drawing.Size(88, 36);
            this.ckLMange.TabIndex = 7;
            this.ckLMange.Visible = false;
            // 
            // radMan
            // 
            this.radMan.AutoSize = true;
            this.radMan.Location = new System.Drawing.Point(75, 209);
            this.radMan.Name = "radMan";
            this.radMan.Size = new System.Drawing.Size(47, 16);
            this.radMan.TabIndex = 13;
            this.radMan.Text = "男生";
            this.radMan.UseVisualStyleBackColor = true;
            // 
            // radWoman
            // 
            this.radWoman.AutoSize = true;
            this.radWoman.Checked = true;
            this.radWoman.Location = new System.Drawing.Point(128, 209);
            this.radWoman.Name = "radWoman";
            this.radWoman.Size = new System.Drawing.Size(47, 16);
            this.radWoman.TabIndex = 14;
            this.radWoman.TabStop = true;
            this.radWoman.Text = "女生";
            this.radWoman.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(368, 311);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ImageList imageList1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox txtAddress;
        private System.Windows.Forms.TextBox txtMail;
        private System.Windows.Forms.TextBox txtPhone;
        private System.Windows.Forms.TextBox txtPass;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Button btnQuit;
        private System.Windows.Forms.Button btnSure;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.CheckedListBox ckLInfo;
        private System.Windows.Forms.CheckBox ckShop;
        private System.Windows.Forms.CheckBox ckMange;
        private System.Windows.Forms.CheckBox ckSell;
        private System.Windows.Forms.CheckBox ckInfo;
        private System.Windows.Forms.CheckedListBox ckLSell;
        private System.Windows.Forms.CheckedListBox ckLShop;
        private System.Windows.Forms.CheckedListBox ckLMange;
        private System.Windows.Forms.RadioButton radWoman;
        private System.Windows.Forms.RadioButton radMan;
    }
}

