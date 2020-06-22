namespace 使用委托写入文本
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.gb_text2 = new System.Windows.Forms.GroupBox();
            this.txtTask2 = new System.Windows.Forms.TextBox();
            this.gb_text1 = new System.Windows.Forms.GroupBox();
            this.txtTask1 = new System.Windows.Forms.TextBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.chbTwo = new System.Windows.Forms.CheckBox();
            this.chbOne = new System.Windows.Forms.CheckBox();
            this.txtTask = new System.Windows.Forms.TextBox();
            this.submit = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.gb_text2.SuspendLayout();
            this.gb_text1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.gb_text2);
            this.groupBox1.Controls.Add(this.gb_text1);
            this.groupBox1.Location = new System.Drawing.Point(13, 13);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(481, 344);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "作业";
            // 
            // gb_text2
            // 
            this.gb_text2.Controls.Add(this.txtTask2);
            this.gb_text2.Location = new System.Drawing.Point(240, 21);
            this.gb_text2.Name = "gb_text2";
            this.gb_text2.Size = new System.Drawing.Size(227, 317);
            this.gb_text2.TabIndex = 0;
            this.gb_text2.TabStop = false;
            this.gb_text2.Text = "作业2";
            // 
            // txtTask2
            // 
            this.txtTask2.Location = new System.Drawing.Point(6, 20);
            this.txtTask2.Multiline = true;
            this.txtTask2.Name = "txtTask2";
            this.txtTask2.Size = new System.Drawing.Size(215, 291);
            this.txtTask2.TabIndex = 0;
            // 
            // gb_text1
            // 
            this.gb_text1.Controls.Add(this.txtTask1);
            this.gb_text1.Location = new System.Drawing.Point(7, 21);
            this.gb_text1.Name = "gb_text1";
            this.gb_text1.Size = new System.Drawing.Size(227, 317);
            this.gb_text1.TabIndex = 0;
            this.gb_text1.TabStop = false;
            this.gb_text1.Text = "作业1";
            // 
            // txtTask1
            // 
            this.txtTask1.Location = new System.Drawing.Point(6, 20);
            this.txtTask1.Multiline = true;
            this.txtTask1.Name = "txtTask1";
            this.txtTask1.Size = new System.Drawing.Size(215, 291);
            this.txtTask1.TabIndex = 0;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.chbTwo);
            this.groupBox2.Controls.Add(this.chbOne);
            this.groupBox2.Location = new System.Drawing.Point(20, 405);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(286, 54);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "书写到";
            // 
            // chbTwo
            // 
            this.chbTwo.AutoSize = true;
            this.chbTwo.Location = new System.Drawing.Point(182, 21);
            this.chbTwo.Name = "chbTwo";
            this.chbTwo.Size = new System.Drawing.Size(54, 16);
            this.chbTwo.TabIndex = 0;
            this.chbTwo.Text = "作业2";
            this.chbTwo.UseVisualStyleBackColor = true;
            // 
            // chbOne
            // 
            this.chbOne.AutoSize = true;
            this.chbOne.Location = new System.Drawing.Point(22, 21);
            this.chbOne.Name = "chbOne";
            this.chbOne.Size = new System.Drawing.Size(54, 16);
            this.chbOne.TabIndex = 0;
            this.chbOne.Text = "作业1";
            this.chbOne.UseVisualStyleBackColor = true;
            // 
            // txtTask
            // 
            this.txtTask.Location = new System.Drawing.Point(26, 369);
            this.txtTask.Name = "txtTask";
            this.txtTask.Size = new System.Drawing.Size(448, 21);
            this.txtTask.TabIndex = 2;
            // 
            // submit
            // 
            this.submit.Location = new System.Drawing.Point(364, 426);
            this.submit.Name = "submit";
            this.submit.Size = new System.Drawing.Size(75, 23);
            this.submit.TabIndex = 3;
            this.submit.Text = "提交";
            this.submit.UseVisualStyleBackColor = true;
            this.submit.Click += new System.EventHandler(this.submit_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(507, 471);
            this.Controls.Add(this.submit);
            this.Controls.Add(this.txtTask);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.gb_text2.ResumeLayout(false);
            this.gb_text2.PerformLayout();
            this.gb_text1.ResumeLayout(false);
            this.gb_text1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox gb_text2;
        private System.Windows.Forms.TextBox txtTask2;
        private System.Windows.Forms.GroupBox gb_text1;
        private System.Windows.Forms.TextBox txtTask1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.CheckBox chbTwo;
        private System.Windows.Forms.CheckBox chbOne;
        private System.Windows.Forms.TextBox txtTask;
        private System.Windows.Forms.Button submit;
    }
}

