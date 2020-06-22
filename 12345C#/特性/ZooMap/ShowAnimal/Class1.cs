using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace ShowAnimal
{
    public class Class1
    {

    }

    //通过此接口调用下面的类方法
    public interface IDrawAnimal
    {
        void ShowAnimal(Graphics g, int x, int y);
    }

    //绘制老虎
    public class Tiger:IDrawAnimal
    {
        public void ShowAnimal(Graphics g, int x, int y)
        {
            Bitmap image = new Bitmap(ImageResource.老虎,170,130);
            g.DrawImage(image, x, y);    
        }
    }
    //绘制天鹅
    public class Swan : IDrawAnimal
    {
        public void ShowAnimal(Graphics g, int x, int y)
        {
            Bitmap image = new Bitmap(ImageResource.天鹅, 170, 130);
            g.DrawImage(image, x, y);
        }
    }

    //绘制金丝猴
    public class GoldenMonkey : IDrawAnimal
    {
        public void ShowAnimal(Graphics g, int x, int y)
        {
            Bitmap image = new Bitmap(ImageResource.金丝猴, 170, 130);
            g.DrawImage(image, x, y);
        }
    }

    //绘制大熊猫
    public class Panda : IDrawAnimal
    {
        public void ShowAnimal(Graphics g, int x, int y)
        {
            Bitmap image = new Bitmap(ImageResource.大熊猫, 170, 130);
            g.DrawImage(image, x, y);
        }
    }

    //绘制大象
    public class Elenphont : IDrawAnimal
    {
        public void ShowAnimal(Graphics g, int x, int y)
        {
            Bitmap image = new Bitmap(ImageResource.大象, 170, 130);
            g.DrawImage(image, x, y);
        }
    }
}
