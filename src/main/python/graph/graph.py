from constants import Color
from termcolor import colored


class Vertex:

    def __init__(self, key):
        self.color = Color.WHITE
        self.key = key
        self.adj_list = []
        self.distance = None
        self.parent = None

    def __str__(self):
        return "Vertex[{}] >>> color={}, distance={}".format(self.key, self.color, self.distance)


class Graph:
    def __init__(self, vertices):
        """
        Dictionary of vertices

        :param vertices: dict
        """
        if type(vertices) != dict:
            raise TypeError(colored("Graph expected to be dictionary of vertices", 'blue'))
        self.vertices = vertices

    def bfs_traversal(self, start_key):
        queue = []
        vertex = self.vertices[start_key]

        vertex.distance = 0
        queue.append(vertex)
        while len(queue) != 0:
            v = queue.pop(0)
            print colored("travering {}".format(v), 'green')

            if v.color == Color.WHITE:
                v.color = Color.GRAY
                for u in v.adj_list:
                    queue.append(u)
                    u.parent = v
                    u.distance = v.distance + 1
                    print colored("{} ".format(u), 'magenta')
            v.color = Color.BLACK


if __name__ == '__main__':
    v1 = Vertex(1)
    v2 = Vertex(2)
    v3 = Vertex(3)
    v4 = Vertex(4)
    v5 = Vertex(5)
    v6 = Vertex(6)
    v7 = Vertex(7)
    v8 = Vertex(8)
    v9 = Vertex(9)
    v10 = Vertex(10)

    v1.adj_list = [v2, v3, v4]
    v2.adj_list = [v5, v6]
    v3.adj_list = [v7, v8]
    v4.adj_list = [v9, v10]
    v6.adj_list = [v9]
    v7.adj_list = [v10]

    vtxs = dict({1: v1, 2: v2, 3: v3, 4: v4, 5: v5, 6: v6, 7: v7, 8: v8, 9: v9, 10: v10})

    graph = Graph(vtxs)
    graph.bfs_traversal(1)

