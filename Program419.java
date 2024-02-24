

class node 
{
    public int data;
    public node next;
    public node prev;

    public node(int no)
    {
        data = no;
        next = null;
        prev = null;
    }
}

class DoublyCL
{
    private node first;
    private node last;
    private int Count;

    public DoublyCL()
    {
        first = null;
        last = null;
        Count = 0;
    }

    public void InsertFirst(int no)
    {
        node newn = new node(no);

        if((first == null) && (last == null))
        {
            first = newn;
            last = newn;
        }
        else 
        {   
            newn.next = first;
            first = newn;
      
        }
        first.prev = last;
        last.next = first;
        Count++;
    }
    public void InsertLast(int no)
    {
        node newn = new node(no);

        if((first == null) && (last == null))
        {
            first = newn;
            last = newn;
        }
        else 
        {
            last.next = newn;
            newn.prev = last;
            last = newn;
        }
        last.next = newn;
        first.prev = last;
        Count++;
    }

    public void DeleteFirst()
    {
        if((first == null) && (last == null))
        {
            return;
        }
        else if( first == last)
        {
            first = null;
            last = null;
        }
        else 
        {
            first = first.next;
            last.next = first;
            first.prev = last;
        }
        Count--;
    }

    public void DeleteLast()
    {
        if((first == null) && (last == null))
        {
            return;
        }
        else if( first == last)
        {
            first = null;
            last = null;
        }
        else 
        {
            last = last.prev;
            last.next = first;
            first.prev = last;
        }
        Count--;

    }

    public void InsertAtPos(int no , int ipos)
    {
        if((ipos < 1) && (ipos > Count + 1))
        {
            System.out.println("Invalid Position:");
            return;
        }

        if(ipos == 1)
        {
            InsertFirst(no);
        }
        else if(ipos == Count + 1) 
        {
            InsertLast(no);
        }
        else 
        {
            node newn = new node(no);
            int i = 0;
            node temp  = first;

            for(i = 1; i < ipos -1; i++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next.prev = newn;
            newn.prev = temp;
            temp.next = newn;
            Count++;
        }
    }

    public void DeleteAtPos(int ipos)
    {
        if((ipos < 1) && (ipos > Count))
        {
            System.out.println("Invalid Posiition");
            return;
        }

        if(ipos == 1)
        {
            DeleteFirst();
        }
        else if(ipos == Count) 
        {
            DeleteLast();
        }
        else 
        {
            int i = 0;
            node temp = first;
            for(i =1; i < ipos - 1; i++)
            {
                temp= temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            Count--;
        }
    }

    public void Display()
    {
        System.out.println("Elements inside  the Linked List are :");

        node temp = first;
        if((first != null) && (last != null))
        {
            do
            {
                System.out.print("| "+temp.data+" |<=>");
                temp = temp.next;
            }
            while(temp.next != last);
        }
    }

    public int Count()
    {
        return Count;
    }
}


class Program419
{
    public static void main(String arg[])
    {

        DoublyCL obj = new DoublyCL();
        int iRet = 0;

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of elements are : "+iRet);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);
        
        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of elements are : "+iRet);

        obj.InsertAtPos(105,5);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of elements are : "+iRet);

        obj.DeleteAtPos(5);
        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of elements are : "+iRet);

        obj.DeleteFirst();
        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of elements are : "+iRet);

        obj.DeleteLast();
        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of elements are : "+iRet);
    }
}