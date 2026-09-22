import java.util.Arrays;
class Solution {
    static class Node {
        int p;
        long[] c;

        Node(int k) {
            p=1;
            c=new long[k];
        }
    }

    Node[] t;
    int[] a;
    int k,n;

    public int[] resultArray(int[] nums,int k,int[][] q) {
        this.a=nums;
        this.k=k;
        n=nums.length;

        t=new Node[4*n];
        build(1,0,n-1);

        int[] ans=new int[q.length];

        for(int i=0;i<q.length;i++) {
            int id=q[i][0];
            int v=q[i][1];
            int s=q[i][2];
            int x=q[i][3];

            update(1,0,n-1,id,v);

            Node z=query(1,0,n-1,s,n-1);
            ans[i]=(int)z.c[x];
        }

        return ans;
    }

    Node merge(Node a,Node b) {
        Node r=new Node(k);

        r.p=(a.p*b.p)%k;

        for(int i=0;i<k;i++)
            r.c[i]+=a.c[i];

        for(int i=0;i<k;i++) {
            int x=(a.p*i)%k;
            r.c[x]+=b.c[i];
        }

        return r;
    }

    void build(int p,int l,int r) {
        if(l==r) {
            t[p]=new Node(k);
            int x=a[l]%k;
            t[p].p=x;
            t[p].c[x]=1;
            return;
        }

        int m=(l+r)/2;

        build(2*p,l,m);
        build(2*p+1,m+1,r);

        t[p]=merge(t[2*p],t[2*p+1]);
    }

    void update(int p,int l,int r,int id,int v) {
        if(l==r) {
            a[id]=v;
            int x=v%k;

            t[p].p=x;
            Arrays.fill(t[p].c,0);
            t[p].c[x]=1;

            return;
        }

        int m=(l+r)/2;

        if(id<=m)
            update(2*p,l,m,id,v);
        else
            update(2*p+1,m+1,r,id,v);

        t[p]=merge(t[2*p],t[2*p+1]);
    }

    Node query(int p,int l,int r,int ql,int qr) {
        if(ql<=l&&r<=qr)
            return t[p];

        int m=(l+r)/2;

        if(qr<=m)
            return query(2*p,l,m,ql,qr);

        if(ql>m)
            return query(2*p+1,m+1,r,ql,qr);

        Node x=query(2*p,l,m,ql,qr);
        Node y=query(2*p+1,m+1,r,ql,qr);

        return merge(x,y);
    }
}