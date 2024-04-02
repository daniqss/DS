package e2;

public class  navalRaidsGame {
    private static MapNode lastVisited;


    private static void simulate(Fleet fleet, MapNode startNode) {
        lastVisited = startNode;

        System.out.println("Fleet attributes: " + fleet.toString());

        boolean sortieResult = executeNode(startNode, fleet);

        if (fleet.getHp() <= 0)
            System.out.println("\nSortie Result: FAIL");
        else
            System.out.println("\nSortie Result: " + (sortieResult ? "SUCCESS" : "FAIL"));

        System.out.println("Last Visited Node: " + lastVisited.getNodeName());
        System.out.println("Final HP: " + fleet.getHp());
    }

    private static boolean executeNode(MapNode node, Fleet fleet) {
        if (node == null) {
            System.out.println("Error: Node is null");
            return false;
        }

        String nodeName = node.getNodeName();
        System.out.println("Executing node: " + nodeName);
        System.out.println("Fleet attributes: " + fleet.toString());

        if (fleet.getHp() <= 0) {
            return false;
        }

        MapNode nextNode = node.nextNode(fleet);

        if (node instanceof End) {
            lastVisited = node;
            return true;
        }

        if (nextNode == null) {
            return false;
        }

        lastVisited = nextNode;

        boolean success = executeNode(nextNode, fleet);

        if (!success) {
            System.out.println("Node execution failed: " + nodeName);
        }

        return success;
    }
    public static int getSmallestNumberRout(MapNode currentNode) {
        if (currentNode == null)
            return -1;

        if (currentNode instanceof End)
            return 1;

        if (currentNode instanceof FixedPathNode fixedPathNode) {
            MapNode child = fixedPathNode.getChild();
            int childCount = getSmallestNumberRout(child);
            return (childCount == -1) ? -1 : childCount + 1;
        }

        if (currentNode instanceof BranchingNode branchingNode) {
            MapNode leftChild = branchingNode.getLeftChild();
            MapNode rightChild = branchingNode.getRightChild();

            int leftCount = getSmallestNumberRout(leftChild);
            int rightCount = getSmallestNumberRout(rightChild);

            if (leftCount == -1 || rightCount == -1) {
                return -1;
            }

            return Math.min(leftCount, rightCount) + 1; // Seleccionamos el más corto
        }

        return -1; // Tipo de nodo no existente
    }

    private static void printMapNode(MapNode currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.print("(");
        System.out.print(currentNode.getNodeName() + " " + currentNode.getClass().getSimpleName());

        if (currentNode instanceof BranchingNode branchingNode) {
            MapNode leftChild = branchingNode.getLeftChild();
            MapNode rightChild = branchingNode.getRightChild();

            if (leftChild != null || rightChild != null)
                System.out.print(", ");

            if (leftChild != null)
                printMapNode(leftChild);

            if (rightChild != null) {
                if (leftChild != null)
                    System.out.print(", ");
                printMapNode(rightChild);
            }
        } else if (currentNode instanceof FixedPathNode fixedPathNode) {
            MapNode child = fixedPathNode.getChild();

            if (child != null) {
                System.out.print(", ");
                printMapNode(child);
            }
        }

        System.out.print(")");
    }

    public static void game(Fleet fleet, MapNode startNode) {

        System.out.println("Result for Fleet:\n");
        simulate(fleet, startNode);

        int smallestNodeCount = navalRaidsGame.getSmallestNumberRout(startNode);
        System.out.println("\nSmallest Node Count to End: " + smallestNodeCount);
        System.out.print("\nStructure of the raid zone: \n"); printMapNode(startNode);
    }
}
