using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 委托窗口
{
    //静态类，用于声明委托、事件、以及事件调用
    public static class Middle
    {
        //定义一个委托类型
        public delegate void SendMessage(string str);
        //定义事件类型
        public static event SendMessage sendEvent;

        //事件调用
        public static void DoSomeMessage(string str)
        {
            sendEvent(str);
        }
    }
}
