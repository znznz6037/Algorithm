<<<<<<< HEAD
#include <iostream>
using namespace std;

template <typename T>
class Tree;

template <typename T>
class TreeNode {
	friend class Tree<T>;
private:
	T data;
	TreeNode<T>* left;
	TreeNode<T>* right;
public:
	TreeNode(T data = 0, TreeNode<T>* left = NULL, TreeNode<T>* right = NULL) {
		this->data = data;
		this->left = left;
		this->right = right;
	}
	friend ostream& operator<<(ostream& os, const TreeNode<T>& node) {
		os << "[data] " << node.data << endl;
		if (node.left != NULL)os << "[left]" << node.left->data << endl;
		else if (node.right != NULL)os << "[right]" << node.right->data << endl;
		return os;
	}
};

template <typename T>
class Tree {
private:
	TreeNode<T>* root;
public:
	Tree(T data = 0) {
		root = new TreeNode<T>(data);
	}
	TreeNode<T>* search(TreeNode<T>* current, T data) {
		if (current == NULL)return NULL;
		if (current->data == data)return current;
		else if (current->data > data)search(current->left, data);
		else search(current->right, data);
	}
	void insertNode(TreeNode<T>* node) {
		if (search(root, node->data) == NULL) {
			TreeNode<T>* parent = NULL;
			TreeNode<T>* current = root;
			while (current != NULL) {
				parent = current;
				if (node->data > parent->data)current = current->right;
				else current = current->left;
			}
			if (parent->data < node->data)parent->right = node;
			else parent->left = node;
		}
	}

	void visit(TreeNode<T>* current) {
		cout << current->data << endl;
	}

	void postorder(TreeNode<T>* current) {
		if (current != NULL) {
			postorder(current->left);
			postorder(current->right);
			visit(current);
		}
	}

	TreeNode<T>* getRoot() {
		return root;
	}
};

int main() {
	int root, x;
	scanf_s("%d", &root);
	Tree<int>tree(root);
	while (scanf_s("%d", &x) != EOF) {
		tree.insertNode(new TreeNode<int>(x));
	}
	tree.postorder(tree.getRoot());
	return 0;
=======
#include <iostream>
using namespace std;

template <typename T>
class Tree;

template <typename T>
class TreeNode {
	friend class Tree<T>;
private:
	T data;
	TreeNode<T>* left;
	TreeNode<T>* right;
public:
	TreeNode(T data = 0, TreeNode<T>* left = NULL, TreeNode<T>* right = NULL) {
		this->data = data;
		this->left = left;
		this->right = right;
	}
	friend ostream& operator<<(ostream& os, const TreeNode<T>& node) {
		os << "[data] " << node.data << endl;
		if (node.left != NULL)os << "[left]" << node.left->data << endl;
		else if (node.right != NULL)os << "[right]" << node.right->data << endl;
		return os;
	}
};

template <typename T>
class Tree {
private:
	TreeNode<T>* root;
public:
	Tree(T data = 0) {
		root = new TreeNode<T>(data);
	}
	TreeNode<T>* search(TreeNode<T>* current, T data) {
		if (current == NULL)return NULL;
		if (current->data == data)return current;
		else if (current->data > data)search(current->left, data);
		else search(current->right, data);
	}
	void insertNode(TreeNode<T>* node) {
		if (search(root, node->data) == NULL) {
			TreeNode<T>* parent = NULL;
			TreeNode<T>* current = root;
			while (current != NULL) {
				parent = current;
				if (node->data > parent->data)current = current->right;
				else current = current->left;
			}
			if (parent->data < node->data)parent->right = node;
			else parent->left = node;
		}
	}

	void visit(TreeNode<T>* current) {
		cout << current->data << endl;
	}

	void postorder(TreeNode<T>* current) {
		if (current != NULL) {
			postorder(current->left);
			postorder(current->right);
			visit(current);
		}
	}

	TreeNode<T>* getRoot() {
		return root;
	}
};

int main() {
	int root, x;
	scanf_s("%d", &root);
	Tree<int>tree(root);
	while (scanf_s("%d", &x) != EOF) {
		tree.insertNode(new TreeNode<int>(x));
	}
	tree.postorder(tree.getRoot());
	return 0;
>>>>>>> c163b3a9c7fbfa6c637a042e8c9a9274dc6f4f4f
}