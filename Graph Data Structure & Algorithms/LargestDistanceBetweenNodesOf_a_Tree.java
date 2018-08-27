/*

Find largest distance
Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree). The nodes will be numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root node.

 Example:
If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this: 
          0
       /  |  \
      1   2   3
               \
                4  
 One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that there are other paths with maximal distance. 
 
 */
 
 class Node;

class Node
{
public:
    int label = 0;
    std::vector<Node*> child;
    Node(int label);
};

int result;

int longestPath(Node *root)
{
    if (root->child.empty())
    {
    return 0;
    }
    int max1 = 0;
    int max2 = 0;
    for (int i = 0;i < root->child.size();i++)
    {
        int temp = 1 + longestPath(root->child[i]);
        if (temp > max1)
        {
            max2 = max1;
            max1 = temp;
        }
        else if (temp > max2)
        {
        max2 = temp;
        }
    }

    if ((max1 + max2) > result)
    {
    result = max1 + max2;
    }
    return std::max(max1,max2);

}


int Solution::solve(vector<int> &A) {
    vector<Node*> tree;
    for (int i = 0;i < A.size();i++)
    {
        Node *temp = new Node(i);
        tree.push_back(temp);
    }
    Node *root = nullptr;
    for (int i = 0;i < A.size();i++)
    {
        if (A[i] == -1)
        {
        root = tree[i];
        }
        else
        {
            tree[A[i]]->child.push_back(tree[i]);
        }
    }
    result = 0;
    longestPath(root);
    return result;
}


Node::Node(int label)
{
    this->label = label;
    child = std::vector<Node*>();
}

