package Tree.BinaryTree;

public class HeroNode {
    private int num;
    private String name;
    private HeroNode leftNode;
    private HeroNode rightNode;

    public HeroNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public HeroNode() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(HeroNode leftNode) {
        this.leftNode = leftNode;
    }

    public HeroNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(HeroNode rightNode) {
        this.rightNode = rightNode;
    }
    //前序遍历
    public void preList(){
        System.out.println(
                this
        );
        if (this.leftNode!=null){
            this.leftNode.preList();;
        }
        if (this.rightNode!=null){
            this.rightNode.preList();
        }
    }
    //中序
    public void midList(){
        if (this.rightNode!=null){
            this.rightNode.midList();
        }
        System.out.println(this);
        if (this.leftNode!=null){
            this.rightNode.midList();
        }

    }
    //后序
    public void postList(){
        if (this.rightNode!=null){
            this.rightNode.midList();
        }

        if (this.leftNode!=null){
            this.rightNode.midList();
        }
        System.out.println(this);

    }

}
