/**
* Definition for binary tree
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/

public class BSTIterator {

  static enum ReturnAddress {
    PRE, IN, POST, DONE;
  }

  static class StackState {
    ReturnAddress returnAddress = ReturnAddress.PRE;
    TreeNode param;

    StackState(TreeNode param){
      this.param = param;
    }
  }

  Deque<StackState> stack = new LinkedList<StackState>();

  public BSTIterator(TreeNode root) {
    if(root != null) {
      stack.push(new StackState(root));
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    if(!stack.isEmpty()){
      StackState current = stack.pop();
      switch(current.returnAddress){
        case PRE:
        case IN:
        stack.push(current);
        return true;

        case POST:
        if(current.param.right != null){
          stack.push(new StackState(current.param.right));
          return true;
        }
      }
      return hasNext();
    }
    return false;
  }

  /** @return the next smallest number */
  public int next() {

    StackState current = stack.pop();
    switch(current.returnAddress){
      case PRE:
      current.returnAddress = ReturnAddress.IN;

      if(current.param.left != null){
        stack.push(current);
        stack.push(new StackState(current.param.left));
        break;
      }

      case IN:
      current.returnAddress = ReturnAddress.POST;
      stack.push(current);
      return current.param.val;

      case POST:
      current.returnAddress = ReturnAddress.DONE;

      if(current.param.right != null){
        stack.push(current);
        stack.push(new StackState(current.param.right));
        break;
      }
    }
    return next();
  }
}

/**
* Your BSTIterator will be called like this:
* BSTIterator i = new BSTIterator(root);
* while (i.hasNext()) v[f()] = i.next();
*/
