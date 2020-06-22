namespace 计算器
{
    partial class frmMain
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
            this.tbResult = new System.Windows.Forms.TextBox();
            this.btnBack = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnReset = new System.Windows.Forms.Button();
            this.btnSign = new System.Windows.Forms.Button();
            this.btnSqrt = new System.Windows.Forms.Button();
            this.btn7 = new System.Windows.Forms.Button();
            this.btn8 = new System.Windows.Forms.Button();
            this.btn9 = new System.Windows.Forms.Button();
            this.btnDivide = new System.Windows.Forms.Button();
            this.btnPersent = new System.Windows.Forms.Button();
            this.btn4 = new System.Windows.Forms.Button();
            this.btn5 = new System.Windows.Forms.Button();
            this.btn6 = new System.Windows.Forms.Button();
            this.btnMultiply = new System.Windows.Forms.Button();
            this.btnInverse = new System.Windows.Forms.Button();
            this.btn1 = new System.Windows.Forms.Button();
            this.btn2 = new System.Windows.Forms.Button();
            this.btn3 = new System.Windows.Forms.Button();
            this.btnSub = new System.Windows.Forms.Button();
            this.btn0 = new System.Windows.Forms.Button();
            this.button23 = new System.Windows.Forms.Button();
            this.btnAdd = new System.Windows.Forms.Button();
            this.btnEqual = new System.Windows.Forms.Button();
            this.btnAns = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // tbResult
            // 
            this.tbResult.Location = new System.Drawing.Point(12, 12);
            this.tbResult.Name = "tbResult";
            this.tbResult.Size = new System.Drawing.Size(260, 21);
            this.tbResult.TabIndex = 0;
            this.tbResult.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // btnBack
            // 
            this.btnBack.Location = new System.Drawing.Point(13, 50);
            this.btnBack.Name = "btnBack";
            this.btnBack.Size = new System.Drawing.Size(47, 35);
            this.btnBack.TabIndex = 1;
            this.btnBack.Text = "←";
            this.btnBack.UseVisualStyleBackColor = true;
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(66, 50);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(47, 35);
            this.btnClear.TabIndex = 1;
            this.btnClear.Text = "CE";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // btnReset
            // 
            this.btnReset.Location = new System.Drawing.Point(119, 50);
            this.btnReset.Name = "btnReset";
            this.btnReset.Size = new System.Drawing.Size(47, 35);
            this.btnReset.TabIndex = 1;
            this.btnReset.Text = "C";
            this.btnReset.UseVisualStyleBackColor = true;
            this.btnReset.Click += new System.EventHandler(this.btnReset_Click);
            // 
            // btnSign
            // 
            this.btnSign.Location = new System.Drawing.Point(172, 50);
            this.btnSign.Name = "btnSign";
            this.btnSign.Size = new System.Drawing.Size(47, 35);
            this.btnSign.TabIndex = 1;
            this.btnSign.Text = "±";
            this.btnSign.UseVisualStyleBackColor = true;
            // 
            // btnSqrt
            // 
            this.btnSqrt.Location = new System.Drawing.Point(225, 50);
            this.btnSqrt.Name = "btnSqrt";
            this.btnSqrt.Size = new System.Drawing.Size(47, 35);
            this.btnSqrt.TabIndex = 1;
            this.btnSqrt.Text = "√";
            this.btnSqrt.UseVisualStyleBackColor = true;
            this.btnSqrt.Click += new System.EventHandler(this.btnSqrt_Click);
            // 
            // btn7
            // 
            this.btn7.Location = new System.Drawing.Point(13, 91);
            this.btn7.Name = "btn7";
            this.btn7.Size = new System.Drawing.Size(47, 35);
            this.btn7.TabIndex = 1;
            this.btn7.Text = "7";
            this.btn7.UseVisualStyleBackColor = true;
            this.btn7.Click += new System.EventHandler(this.btn7_Click);
            // 
            // btn8
            // 
            this.btn8.Location = new System.Drawing.Point(66, 91);
            this.btn8.Name = "btn8";
            this.btn8.Size = new System.Drawing.Size(47, 35);
            this.btn8.TabIndex = 1;
            this.btn8.Text = "8";
            this.btn8.UseVisualStyleBackColor = true;
            this.btn8.Click += new System.EventHandler(this.btn8_Click);
            // 
            // btn9
            // 
            this.btn9.Location = new System.Drawing.Point(119, 91);
            this.btn9.Name = "btn9";
            this.btn9.Size = new System.Drawing.Size(47, 35);
            this.btn9.TabIndex = 1;
            this.btn9.Text = " 9";
            this.btn9.UseVisualStyleBackColor = true;
            this.btn9.Click += new System.EventHandler(this.btn9_Click);
            // 
            // btnDivide
            // 
            this.btnDivide.Location = new System.Drawing.Point(172, 91);
            this.btnDivide.Name = "btnDivide";
            this.btnDivide.Size = new System.Drawing.Size(47, 35);
            this.btnDivide.TabIndex = 1;
            this.btnDivide.Text = "/";
            this.btnDivide.UseVisualStyleBackColor = true;
            this.btnDivide.Click += new System.EventHandler(this.btnDivide_Click);
            // 
            // btnPersent
            // 
            this.btnPersent.Location = new System.Drawing.Point(225, 91);
            this.btnPersent.Name = "btnPersent";
            this.btnPersent.Size = new System.Drawing.Size(47, 35);
            this.btnPersent.TabIndex = 1;
            this.btnPersent.Text = "%";
            this.btnPersent.UseVisualStyleBackColor = true;
            this.btnPersent.Click += new System.EventHandler(this.btnPersent_Click);
            // 
            // btn4
            // 
            this.btn4.Location = new System.Drawing.Point(13, 132);
            this.btn4.Name = "btn4";
            this.btn4.Size = new System.Drawing.Size(47, 35);
            this.btn4.TabIndex = 1;
            this.btn4.Text = "4";
            this.btn4.UseVisualStyleBackColor = true;
            this.btn4.Click += new System.EventHandler(this.btn4_Click);
            // 
            // btn5
            // 
            this.btn5.Location = new System.Drawing.Point(66, 132);
            this.btn5.Name = "btn5";
            this.btn5.Size = new System.Drawing.Size(47, 35);
            this.btn5.TabIndex = 1;
            this.btn5.Text = "5";
            this.btn5.UseVisualStyleBackColor = true;
            this.btn5.Click += new System.EventHandler(this.btn5_Click);
            // 
            // btn6
            // 
            this.btn6.Location = new System.Drawing.Point(119, 132);
            this.btn6.Name = "btn6";
            this.btn6.Size = new System.Drawing.Size(47, 35);
            this.btn6.TabIndex = 1;
            this.btn6.Text = "6";
            this.btn6.UseVisualStyleBackColor = true;
            this.btn6.Click += new System.EventHandler(this.btn6_Click);
            // 
            // btnMultiply
            // 
            this.btnMultiply.Location = new System.Drawing.Point(172, 132);
            this.btnMultiply.Name = "btnMultiply";
            this.btnMultiply.Size = new System.Drawing.Size(47, 35);
            this.btnMultiply.TabIndex = 1;
            this.btnMultiply.Text = "*";
            this.btnMultiply.UseVisualStyleBackColor = true;
            this.btnMultiply.Click += new System.EventHandler(this.btnMultiply_Click);
            // 
            // btnInverse
            // 
            this.btnInverse.Location = new System.Drawing.Point(225, 132);
            this.btnInverse.Name = "btnInverse";
            this.btnInverse.Size = new System.Drawing.Size(47, 35);
            this.btnInverse.TabIndex = 1;
            this.btnInverse.Text = "1/x";
            this.btnInverse.UseVisualStyleBackColor = true;
            this.btnInverse.Click += new System.EventHandler(this.btnInverse_Click);
            // 
            // btn1
            // 
            this.btn1.Location = new System.Drawing.Point(12, 173);
            this.btn1.Name = "btn1";
            this.btn1.Size = new System.Drawing.Size(47, 35);
            this.btn1.TabIndex = 1;
            this.btn1.Text = "1";
            this.btn1.UseVisualStyleBackColor = true;
            this.btn1.Click += new System.EventHandler(this.btn1_Click);
            // 
            // btn2
            // 
            this.btn2.Location = new System.Drawing.Point(66, 173);
            this.btn2.Name = "btn2";
            this.btn2.Size = new System.Drawing.Size(47, 35);
            this.btn2.TabIndex = 1;
            this.btn2.Text = "2";
            this.btn2.UseVisualStyleBackColor = true;
            this.btn2.Click += new System.EventHandler(this.btn2_Click);
            // 
            // btn3
            // 
            this.btn3.Location = new System.Drawing.Point(119, 173);
            this.btn3.Name = "btn3";
            this.btn3.Size = new System.Drawing.Size(47, 35);
            this.btn3.TabIndex = 1;
            this.btn3.Text = "3";
            this.btn3.UseVisualStyleBackColor = true;
            this.btn3.Click += new System.EventHandler(this.btn3_Click);
            // 
            // btnSub
            // 
            this.btnSub.Location = new System.Drawing.Point(172, 173);
            this.btnSub.Name = "btnSub";
            this.btnSub.Size = new System.Drawing.Size(47, 35);
            this.btnSub.TabIndex = 1;
            this.btnSub.Text = "-";
            this.btnSub.UseVisualStyleBackColor = true;
            this.btnSub.Click += new System.EventHandler(this.btnSub_Click);
            // 
            // btn0
            // 
            this.btn0.Location = new System.Drawing.Point(66, 214);
            this.btn0.Name = "btn0";
            this.btn0.Size = new System.Drawing.Size(47, 35);
            this.btn0.TabIndex = 1;
            this.btn0.Text = "0";
            this.btn0.UseVisualStyleBackColor = true;
            this.btn0.Click += new System.EventHandler(this.btn0_Click);
            // 
            // button23
            // 
            this.button23.Location = new System.Drawing.Point(119, 214);
            this.button23.Name = "button23";
            this.button23.Size = new System.Drawing.Size(47, 35);
            this.button23.TabIndex = 1;
            this.button23.Text = ".";
            this.button23.UseVisualStyleBackColor = true;
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(172, 214);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(47, 35);
            this.btnAdd.TabIndex = 1;
            this.btnAdd.Text = "+";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // btnEqual
            // 
            this.btnEqual.Location = new System.Drawing.Point(225, 173);
            this.btnEqual.Name = "btnEqual";
            this.btnEqual.Size = new System.Drawing.Size(47, 76);
            this.btnEqual.TabIndex = 1;
            this.btnEqual.Text = "=";
            this.btnEqual.UseVisualStyleBackColor = true;
            this.btnEqual.Click += new System.EventHandler(this.btnEqual_Click);
            // 
            // btnAns
            // 
            this.btnAns.Location = new System.Drawing.Point(13, 214);
            this.btnAns.Name = "btnAns";
            this.btnAns.Size = new System.Drawing.Size(47, 35);
            this.btnAns.TabIndex = 2;
            this.btnAns.Text = "Ans";
            this.btnAns.UseVisualStyleBackColor = true;
            this.btnAns.Click += new System.EventHandler(this.btnAns_Click);
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(286, 263);
            this.Controls.Add(this.btnAns);
            this.Controls.Add(this.btnEqual);
            this.Controls.Add(this.btnInverse);
            this.Controls.Add(this.btnPersent);
            this.Controls.Add(this.btnSqrt);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.btnSub);
            this.Controls.Add(this.btnMultiply);
            this.Controls.Add(this.btnDivide);
            this.Controls.Add(this.btnSign);
            this.Controls.Add(this.button23);
            this.Controls.Add(this.btn3);
            this.Controls.Add(this.btn6);
            this.Controls.Add(this.btn9);
            this.Controls.Add(this.btnReset);
            this.Controls.Add(this.btn2);
            this.Controls.Add(this.btn5);
            this.Controls.Add(this.btn8);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btn0);
            this.Controls.Add(this.btn1);
            this.Controls.Add(this.btn4);
            this.Controls.Add(this.btn7);
            this.Controls.Add(this.btnBack);
            this.Controls.Add(this.tbResult);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Name = "frmMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "计算器";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox tbResult;
        private System.Windows.Forms.Button btnBack;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnReset;
        private System.Windows.Forms.Button btnSign;
        private System.Windows.Forms.Button btnSqrt;
        private System.Windows.Forms.Button btn7;
        private System.Windows.Forms.Button btn8;
        private System.Windows.Forms.Button btn9;
        private System.Windows.Forms.Button btnDivide;
        private System.Windows.Forms.Button btnPersent;
        private System.Windows.Forms.Button btn4;
        private System.Windows.Forms.Button btn5;
        private System.Windows.Forms.Button btn6;
        private System.Windows.Forms.Button btnMultiply;
        private System.Windows.Forms.Button btnInverse;
        private System.Windows.Forms.Button btn1;
        private System.Windows.Forms.Button btn2;
        private System.Windows.Forms.Button btn3;
        private System.Windows.Forms.Button btnSub;
        private System.Windows.Forms.Button btn0;
        private System.Windows.Forms.Button button23;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button btnEqual;
        private System.Windows.Forms.Button btnAns;
    }
}

