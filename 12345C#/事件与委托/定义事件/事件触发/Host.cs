using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 事件触发
{
    class Host
    {
        //编写事件处理函数
        public void HostHandleAlarm(object sender,EventArgs e)
        {
            Console.WriteLine("主人：抓住小偷");
        }
    }
}
