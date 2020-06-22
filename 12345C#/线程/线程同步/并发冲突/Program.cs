using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 并发冲突
{
    class Program
    {
        static void Main(string[] args)
        {
            StateObject state=new StateObject();
            Thread t;
            for(int i=0;i<20;i++)
            {
                //开启20个线程，让他们去操作state对象里的状态数，
                t = new Thread(new ThreadSample().RaceCondition);
                t.Name = i.ToString()+"号线程";
                t.Start(state);
            }
        }
    }

    public class StateObject
    {
        //这个类里面有一个state。
        private int state = 5;

        public void ChangeValue(int loop)
        {
            if(state==5)
            {
                //当某一个线程运行到此处时，state是5，然后该线程将状态值加1，然后紧接着判断状态值是不是6，
                //如果不是6，说明，state的值被其它线程也加1了，导致state的值不为6，引发访问冲突
                state++;

                System.Diagnostics.Trace.Assert(state == 6, loop + "次循环以后发生了并发问题");
            }

            state = 5;
        }
    }

    public class ThreadSample
    {
        public void RaceCondition(object ob)
        {
            System.Diagnostics.Trace.Assert(ob is StateObject, "参数必须是stateObject类型");
            int i = 0;
            StateObject state = ob as StateObject;
            while(true)
            {
                lock (state)
                {
                    state.ChangeValue(i++);
                    Console.WriteLine(Thread.CurrentThread.Name);
                }
            }
        }
    }
}
