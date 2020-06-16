package com.hero.linked;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        //创建节点
        Node hero1 = new Node(1,"宋江","及时雨");
        Node hero2 = new Node(2,"卢俊义","玉麒麟");
        Node hero3 = new Node(3,"吴用","智多星");
        Node hero4 = new Node(4,"公孙胜","入云龙");
        Node hero5 = new Node(5,"关胜","大刀");
        Node hero7= new Node(7,"秦明","霹雳火");
        Node hero6 = new Node(6,"林冲","豹子头");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addNode(hero1);
        linkedList.addNode(hero2);
        linkedList.addNode(hero3);
        linkedList.addNode(hero4);
        linkedList.addNode(hero5);
        linkedList.show();
        Node temp = new Node(5,"关胜","大刀~~");
        linkedList.updateNode(temp);
        System.out.println("------------修改后--------------");
        linkedList.show();
        System.out.println("------------删除后--------------");
        linkedList.deleteNode(3);
        linkedList.show();
        System.out.println("------------反转后--------------");
        linkedList.revorse();
        linkedList.show();
        System.out.println("------------反转打印后--------------");
        linkedList.revorsePrint();

    }

}

class SingleLinkedList{

    //创建头结点
    private Node head = new Node(0,"","");

    //添加节点到链表(无序插入，直接插入到链表尾部)
    public void  addNode(Node node){
        Node temp = head;
        //头结点不动，向后遍历找到空的
        while(true){
            if(temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
        }
        //找到位置，进行插入
        temp.setNext(node);
    }

    //添加节点到链表(有序插入)

    //删除节点
    public void deleteNode(int id){
        Node temp = head;
        boolean flag = false;
        while(true){

            if(temp.getNext() == null){
                break;
            }
            if(temp.getNext().getId() == id){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(flag){
            temp.setNext(temp.getNext().getNext());
        }else {
            System.out.println("找不到对应的英雄");
        }
    }
    //修改节点
    public void updateNode(Node node){
        Node temp = head;

        boolean flag = false;
        while(true){
            //遍历到链表尾部
            if(temp.getNext() == null){
               break;
            }
            if(temp.getNext().getId().equals(node.getId())){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(flag){
            temp.getNext().setName(node.getName());
            temp.getNext().setNickName(node.getNickName());
        }else{
            System.out.println("找不到对应的英雄");
        }
    }

    //显示链表
    public void show(){
        if(head.getNext() == null){
            System.out.println("链表为空");
        }
        Node temp = head.getNext();
        while(true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
    //显示有效节点个数
    public int  getNodeNum(){
        if(head.getNext() == null){
            System.out.println("链表为空");
        }
        int num = 0;
        Node temp = head.getNext();
        while(temp!=null){
            num++;
            temp = temp.getNext();
        }
        return num;
    }
    //链表反向打印
    public void   revorsePrint(){
        if(head.getNext() == null){
            System.out.println("链表为空");
            return ;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = head.getNext();
        while(temp!=null){
            stack.push(temp);
            temp = temp.getNext();
        }
        //将栈打印
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    //链表反转
    public void revorse(){
        //如果链表为空或链表只有一个元素就直接返回
        if(head.getNext() == null|| head.getNext().getNext()==null) {
            return;
        }

        Node temp = head.getNext();
        Node next = null;
        Node nodeRevorse = new Node(0,"","");
        while(temp !=null){
            //获取当前节点的想一个节点
            next =  temp.getNext();
            temp.setNext(nodeRevorse.getNext());
            nodeRevorse.setNext(temp);

            temp = next;
        }
        head.setNext(nodeRevorse.getNext());
    }

}