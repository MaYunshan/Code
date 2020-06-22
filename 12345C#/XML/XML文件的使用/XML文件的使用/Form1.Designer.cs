namespace XML文件的使用
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
            this.btn_readXML = new System.Windows.Forms.Button();
            this.btn_writeXML = new System.Windows.Forms.Button();
            this.treeView1 = new System.Windows.Forms.TreeView();
            this.btn_getOneNode = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btn_readXML
            // 
            this.btn_readXML.Location = new System.Drawing.Point(12, 12);
            this.btn_readXML.Name = "btn_readXML";
            this.btn_readXML.Size = new System.Drawing.Size(154, 23);
            this.btn_readXML.TabIndex = 0;
            this.btn_readXML.Text = "读取XML文档";
            this.btn_readXML.UseVisualStyleBackColor = true;
            this.btn_readXML.Click += new System.EventHandler(this.btn_readXML_Click);
            // 
            // btn_writeXML
            // 
            this.btn_writeXML.Location = new System.Drawing.Point(183, 12);
            this.btn_writeXML.Name = "btn_writeXML";
            this.btn_writeXML.Size = new System.Drawing.Size(154, 23);
            this.btn_writeXML.TabIndex = 0;
            this.btn_writeXML.Text = "写入XML文档";
            this.btn_writeXML.UseVisualStyleBackColor = true;
            this.btn_writeXML.Click += new System.EventHandler(this.btn_writeXML_Click);
            // 
            // treeView1
            // 
            this.treeView1.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.treeView1.Location = new System.Drawing.Point(12, 66);
            this.treeView1.Name = "treeView1";
            this.treeView1.Size = new System.Drawing.Size(325, 414);
            this.treeView1.TabIndex = 1;
            // 
            // btn_getOneNode
            // 
            this.btn_getOneNode.Location = new System.Drawing.Point(13, 37);
            this.btn_getOneNode.Name = "btn_getOneNode";
            this.btn_getOneNode.Size = new System.Drawing.Size(153, 23);
            this.btn_getOneNode.TabIndex = 2;
            this.btn_getOneNode.Text = "获取XML文档的一个节点";
            this.btn_getOneNode.UseVisualStyleBackColor = true;
            this.btn_getOneNode.Click += new System.EventHandler(this.btn_getOneNode_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(348, 483);
            this.Controls.Add(this.btn_getOneNode);
            this.Controls.Add(this.treeView1);
            this.Controls.Add(this.btn_writeXML);
            this.Controls.Add(this.btn_readXML);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btn_readXML;
        private System.Windows.Forms.Button btn_writeXML;
        private System.Windows.Forms.TreeView treeView1;
        private System.Windows.Forms.Button btn_getOneNode;
    }
}

