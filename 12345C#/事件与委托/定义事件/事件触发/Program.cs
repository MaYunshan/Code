using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 事件触发
{
    class Program
    {
        static void Main(string[] args)
        {
            Dog dog=new Dog();
            Host host=new Host();

            dog.Alarm += new Dog.AlarmEventHandler(host.HostHandleAlarm);
            dog.OnAlarm();
        }
    }
}
