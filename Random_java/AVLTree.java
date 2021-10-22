package com.cdw.dsapart2;

public class AVLTree {
 AVLnode root;
 AVLTree(){
     root = null;
 }
 void add(int v)
 {
     root = add(root,v);
 }
private int hgt(AVLnode a)
{
    return (a==null)? -1:a.height;
}
 private AVLnode add(AVLnode root,int v)
 {
     if(root==null)
         return new AVLnode(v);;
     if(v<root.value)
         root.left = add(root.left,v);
     if(v>root.value)
         root.right =add(root.right,v);
     root.height = Math.max(hgt(root.left),hgt(root.right))+1;
    return balance(root);
 }
 AVLnode balance(AVLnode root)
 {
     if(isleftheavy(root)) {
         if(balancefactor(root.left)<0)
             root.left = leftrotate(root.left);
         rightrotate(root);
     }
     else if(isrightheavy(root)) {
         if(balancefactor(root.right)>0)
         {
             root.right = rightrotate(root.right);
         }
         leftrotate(root);
     }
     return (root);
 }
 void sethgt(AVLnode a)
 {
     a.height  = Math.max(hgt(a.left),hgt(a.right))+1;
 }
 AVLnode rightrotate(AVLnode root)
 {
     AVLnode newRoot = root.left;
     root.left = newRoot.right;
     newRoot.right = root;
     sethgt(root);
     sethgt(newRoot);
     return newRoot;
 }
 AVLnode leftrotate(AVLnode root)
 {
     AVLnode newRoot = root.right;
     root.right = newRoot.left;
     newRoot.left = root;
     sethgt(root);
     sethgt(newRoot);
     return newRoot;
 }
 int balancefactor(AVLnode A)
 {
     return A==null?-1:hgt(A.left)-hgt(A.right);
 }
 boolean isleftheavy(AVLnode A)
 {
     return balancefactor(A)>1? true : false;
 }
 boolean isrightheavy(AVLnode A)
 {
        return balancefactor(A)<-1? true : false;
 }
}
