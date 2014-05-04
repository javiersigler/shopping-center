package proyect;

public class SNode<E> {

	public SNode<E> nextNode = null;

	E elem;

	public SNode<E> getNextNode() {
		return nextNode;
	}

	public E getElement() {
		return elem;
	}

	public void setElement(E e) {
		this.elem = e;
	}

	public SNode(E e) {
		elem = e;
	}

	public SNode(E elem, SNode<E> nextNode) {
		this.elem = elem;
		this.nextNode = nextNode;
	}
	
}
