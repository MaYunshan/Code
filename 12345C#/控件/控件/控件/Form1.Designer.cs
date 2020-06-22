namespace 控件
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
            this.btn_open = new System.Windows.Forms.Button();
            this.btn_open2 = new System.Windows.Forms.Button();
            this.btn_open4 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btn_open
            // 
            this.btn_open.Location = new System.Drawing.Point(237, 141);
            this.btn_open.Name = "btn_open";
            this.btn_open.Size = new System.Drawing.Size(75, 23);
            this.btn_open.TabIndex = 0;
            this.btn_open.Text = "打开";
            this.btn_open.UseVisualStyleBackColor = true;
            this.btn_open.Click += new System.EventHandler(this.btn_open_Click);
            this.btn_open.MouseEnter += new System.EventHandler(this.btn_open_MouseEnter);
            this.btn_open.MouseLeave += new System.EventHandler(this.btn_open_MouseLeave);
            // 
            // btn_open2
            // 
            this.btn_open2.Location = new System.Drawing.Point(237, 197);
            this.btn_open2.Name = "btn_open2";
            this.btn_open2.Size = new System.Drawing.Size(75, 23);
            this.btn_open2.TabIndex = 1;
            this.btn_open2.Text = "打开窗口2";
            this.btn_open2.UseVisualStyleBackColor = true;
            this.btn_open2.Click += new System.EventHandler(this.btn_open2_Click);
            // 
            // btn_open4
            // 
            this.btn_open4.Location = new System.Drawing.Point(237, 250);
            this.btn_open4.Name = "btn_open4";
            this.btn_open4.Size = new System.Drawing.Size(75, 23);
            this.btn_open4.TabIndex = 2;
            this.btn_open4.Text = "打开窗口4";
            this.btn_open4.UseVisualStyleBackColor = true;
            this.btn_open4.Click += new System.EventHandler(this.btn_open4_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(526, 325);
            this.Controls.Add(this.btn_open4);
            this.Controls.Add(this.btn_open2);
            this.Controls.Add(this.btn_open);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btn_open;
        private System.Windows.Forms.Button btn_open2;
        private System.Windows.Forms.Button btn_open4;


    }
}

