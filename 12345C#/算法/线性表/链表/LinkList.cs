using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 链表
{
    class LinkList1<T>:IListDS<T>
    {
        private Node<T> head;//存储一个头结点

        public LinkList1()
        {
            head = null;
        }
        public int GetLength()
        {
            if (head == null) return 0;
            Node<T> temp = head;
            int count = 1;
            while (true)
            {
                if (temp.Next != null)
                {
                    count++;
                    temp = temp.Next;
                }
                else
                {
                    break;
                }
            }
            return count;
        }

        public void Clear()
        {
            head = null;
        }

        public bool IsEmpty()
        {
            return head == null;
        }

        public void Add(T item)
        {
            Node<T> newNode = new Node<T>(item);
            if (head == null)                   //如果链表为空
                head = newNode;
            else                                //如果链表不为空
            {
                Node<T> node = head;
                while (node.Next != null)        //找到尾节点
                    node = node.Next;
                node.Next = newNode;
            }
        }

        public void Insert(T item, int index)
        {
            Node<T> newNode = new Node<T>(item);
            if(index==0)                        //插在头节点
            {
                newNode.Next = head;
                head = newNode;
            }
            else
            {
                Node<T> temp = head;                //找到插入位置
                for (int i = 0; i < index - 1; i++)
                    temp = temp.Next;

                newNode.Next = temp.Next;
                temp.Next = newNode;
            }
        }

        public T Delete(int index)
        {
            T data = default(T);
            if (index == 0) //删除头结点
            {
                data = head.Data;
                head = head.Next;
            }
            else
            {
                Node<T> temp = head;
                for (int i = 1; i <= index - 1; i++)    //找到删除节点的前一个节点
                {
                    //让temp向后移动一个位置
                    temp = temp.Next;
                }
                Node<T> preNode = temp;
                Node<T> currentNode = temp.Next;
                data = currentNode.Data;
                Node<T> nextNode = temp.Next.Next;
                preNode.Next = nextNode;
            }
            return data;
        }

        public T GetEle(int index)
        {
            return this[index];
        }

        public T this[int index]
        {
            get
            {
                Node<T> temp = head;
                for (int i = 1; i <= index; i++)
                {
                    //让temp向后移动一个位置
                    temp = temp.Next;
                }
                return temp.Data;
            }
        }

        public int Locate(T item)
        {
            Node<T> node = head;
            int index=0;
            if (node == null)
                return -1;
            else
            {
                while(node.Next!=null)
                {
                    if (node.Data.Equals(item))
                    {
                        return index;
                    }
                    else
                    {
                        node = node.Next;
                        index++;
                    }    
                }
                return -1;
            }
        }
    }
}
