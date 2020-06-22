using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 链表
{
    class Node<T>
    {
        private T data;
        private Node<T> next;

        public T Data
        {
            get { return data; }
            set { data = value; }
        }
       
        internal Node<T> Next
        {
            get { return next; }
            set { next = value; }
        }

        public Node()
        {
            data = default(T);
            next = null;
        }
        public Node(T value)
        {
            data = value;
            next = null;
        }
        public Node(T value,Node<T> next)
        {
            this.data = value;
            this.next = next;
        }
        public Node(Node<T> next)
        {
            this.next = next;
        }
    }
}
