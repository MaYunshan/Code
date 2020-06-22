namespace 把XML当做数据库实现增删改查
{
    partial class FrmLogin
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnLog = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.txtInPwd = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtInLogID = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // btnLog
            // 
            this.btnLog.Location = new System.Drawing.Point(94, 149);
            this.btnLog.Name = "btnLog";
            this.btnLog.Size = new System.Drawing.Size(75, 23);
            this.btnLog.TabIndex = 0;
            this.btnLog.Text = "登录";
            this.btnLog.UseVisualStyleBackColor = true;
            this.btnLog.Click += new System.EventHandler(this.btnLog_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(48, 105);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 12);
            this.label1.TabIndex = 1;
            this.label1.Text = "Password";
            // 
            // txtInPwd
            // 
            this.txtInPwd.Location = new System.Drawing.Point(139, 102);
            this.txtInPwd.Name = "txtInPwd";
            this.txtInPwd.Size = new System.Drawing.Size(100, 21);
            this.txtInPwd.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(48, 46);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(47, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "LoginID";
            // 
            // txtInLogID
            // 
            this.txtInLogID.Location = new System.Drawing.Point(139, 43);
            this.txtInLogID.Name = "txtInLogID";
            this.txtInLogID.Size = new System.Drawing.Size(100, 21);
            this.txtInLogID.TabIndex = 2;
            // 
            // FrmLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 199);
            this.Controls.Add(this.txtInLogID);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtInPwd);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnLog);
            this.Name = "FrmLogin";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "FrmLogin";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnLog;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtInPwd;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtInLogID;
    }
}