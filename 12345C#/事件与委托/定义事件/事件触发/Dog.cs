using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 事件触发
{
    class Dog
    {
        //声明事件的委托
        public delegate void AlarmEventHandler(object sender, EventArgs e);

        //声明事件
        public event AlarmEventHandler Alarm;

        //引发事件的函数
        public void OnAlarm()
        {
            if(this.Alarm!=null)
            {
                Console.WriteLine("狗报警：有小偷进来了");
                Alarm(this, new EventArgs());
            }
        }

    }
}
