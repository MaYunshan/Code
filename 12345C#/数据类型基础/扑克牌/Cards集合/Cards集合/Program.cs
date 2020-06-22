using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Ch11CardLib;

namespace Cards集合
{
    class Program
    {
        static void Main(string[] args)
        {
            #region Code for "Adding a Cards Collection to CardLib" section.
            Deck myDeck = new Deck();
            myDeck.Shuffle();
            for (int i = 0; i < 52; i++)
            {
                Card tempCard = myDeck.GetCard(i);
                Console.Write(tempCard.ToString());
                if (i != 51)
                    Console.Write(", ");
                else
                    Console.WriteLine();
            }
            Console.ReadKey();
            #endregion
        }
    }
}
