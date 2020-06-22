namespace ZooMap
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
            this.btn_tiger = new System.Windows.Forms.Button();
            this.btn_elephont = new System.Windows.Forms.Button();
            this.btn_swan = new System.Windows.Forms.Button();
            this.btn_panda = new System.Windows.Forms.Button();
            this.btn_monkey = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btn_tiger
            // 
            this.btn_tiger.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btn_tiger.Location = new System.Drawing.Point(127, 188);
            this.btn_tiger.Name = "btn_tiger";
            this.btn_tiger.Size = new System.Drawing.Size(85, 28);
            this.btn_tiger.TabIndex = 0;
            this.btn_tiger.Text = "老虎";
            this.btn_tiger.UseVisualStyleBackColor = true;
            this.btn_tiger.Click += new System.EventHandler(this.btn_tiger_Click);
            // 
            // btn_elephont
            // 
            this.btn_elephont.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btn_elephont.Location = new System.Drawing.Point(465, 308);
            this.btn_elephont.Name = "btn_elephont";
            this.btn_elephont.Size = new System.Drawing.Size(85, 28);
            this.btn_elephont.TabIndex = 0;
            this.btn_elephont.Text = "大象";
            this.btn_elephont.UseVisualStyleBackColor = true;
            this.btn_elephont.Click += new System.EventHandler(this.btn_elephont_Click);
            // 
            // btn_swan
            // 
            this.btn_swan.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btn_swan.Location = new System.Drawing.Point(710, 149);
            this.btn_swan.Name = "btn_swan";
            this.btn_swan.Size = new System.Drawing.Size(85, 28);
            this.btn_swan.TabIndex = 0;
            this.btn_swan.Text = "天鹅";
            this.btn_swan.UseVisualStyleBackColor = true;
            this.btn_swan.Click += new System.EventHandler(this.btn_swan_Click);
            // 
            // btn_panda
            // 
            this.btn_panda.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btn_panda.Location = new System.Drawing.Point(252, 535);
            this.btn_panda.Name = "btn_panda";
            this.btn_panda.Size = new System.Drawing.Size(85, 28);
            this.btn_panda.TabIndex = 0;
            this.btn_panda.Text = "大熊猫";
            this.btn_panda.UseVisualStyleBackColor = true;
            this.btn_panda.Click += new System.EventHandler(this.btn_panda_Click);
            // 
            // btn_monkey
            // 
            this.btn_monkey.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btn_monkey.Location = new System.Drawing.Point(804, 511);
            this.btn_monkey.Name = "btn_monkey";
            this.btn_monkey.Size = new System.Drawing.Size(85, 28);
            this.btn_monkey.TabIndex = 0;
            this.btn_monkey.Text = "金丝猴";
            this.btn_monkey.UseVisualStyleBackColor = true;
            this.btn_monkey.Click += new System.EventHandler(this.btn_monkey_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(980, 590);
            this.Controls.Add(this.btn_monkey);
            this.Controls.Add(this.btn_panda);
            this.Controls.Add(this.btn_swan);
            this.Controls.Add(this.btn_elephont);
            this.Controls.Add(this.btn_tiger);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btn_tiger;
        private System.Windows.Forms.Button btn_elephont;
        private System.Windows.Forms.Button btn_swan;
        private System.Windows.Forms.Button btn_panda;
        private System.Windows.Forms.Button btn_monkey;
    }
}

