using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 特性1
{
    class Program
    {
        static void Main(string[] args)
        {

            //Wolf wolf = new Wolf();
            //wolf.DrawMyself();
            Attribute[] at = Attribute.GetCustomAttributes(typeof(Wolf), typeof(AnimalInfoAttribute));
            AnimalInfoAttribute[] wolfAttiribute = at as AnimalInfoAttribute[];
            if(wolfAttiribute==null)
            {
                Console.WriteLine("没有找到特性");

            }
            else
            {
                Console.WriteLine(wolfAttiribute[0].Name);
                Console.WriteLine(wolfAttiribute[1].Phylum);
                Console.WriteLine(wolfAttiribute[0].Classis);
                Console.WriteLine(wolfAttiribute[1].Familia);
            }
        }
    }
    [AnimalInfo("狼","犬科",Classis="哺乳纲",Phylum="脊椎动物门")]
    [AnimalInfo("wolf","Candis",Classis="Mammals",Phylum="Chordata")]
    class Wolf
    {
        [Obsolete("该方法已经过期，请使用新方法NewDrawMyse()",false)]
        public void DrawMyself()
        {
            Console.WriteLine("画狼的方法");
        }

        public void NewDrawMyself()
        {
            Console.WriteLine("新画狼的方法");
        }
    }
}
