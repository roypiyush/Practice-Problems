from enum import Enum
from termcolor import colored


class Color(Enum):
    WHITE = 1
    GRAY = 2
    BLACK = 3


class Vertex:

    def __init__(self, key):
        self.color = Color.WHITE
        self.key = key
        self.adj_list = []
        self.distance = None
        self.parent = None
        self.start_time = None
        self.end_time = None

    def __str__(self):
        return "Key={} Color={} D={} st={} et={}".format(self.key, self.color,
                                                         self.distance, self.start_time, self.end_time)


class Graph:
    def __init__(self, vertices):
        """
        Dictionary of vertices

        :param vertices: dict
        """
        if type(vertices) != dict:
            raise TypeError(colored("Graph expected to be dictionary of vertices", 'blue'))
        self.vertices = vertices
        self.time = 0
        self.topological_sort_order = []

    def breath_first_search(self, start_key):
        queue = []
        vertex = self.vertices[start_key]

        vertex.distance = 0
        queue.append(vertex)
        while len(queue) != 0:
            v = queue.pop(0)
            print(colored("Traversing {}".format(v), 'green'))

            if v.color == Color.WHITE:
                v.color = Color.GRAY
                for u in v.adj_list:
                    queue.append(u)
                    u.parent = v
                    u.distance = v.distance + 1
                    print(colored("{} ".format(u), 'magenta'))
            v.color = Color.BLACK

    def depth_first_search(self):
        for v in self.vertices.values():
            if v.color == Color.WHITE:
                self.__depth_first_visit(v)

    def __depth_first_visit(self, vertex):
        self.time += 1
        vertex.start_time = self.time
        vertex.color = Color.GRAY
        for v in vertex.adj_list:
            if v.color == Color.WHITE:
                self.__depth_first_visit(v)
        self.time += 1
        vertex.end_time = self.time
        vertex.color = Color.BLACK
        self.topological_sort_order.insert(0, vertex)

    def print_vertices(self):
        for v in self.vertices.values():
            print(v)

    def topological_sort(self):
        return self.topological_sort_order


def __main__():
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
    vertices = dict({1: v1, 2: v2, 3: v3, 4: v4, 5: v5, 6: v6, 7: v7, 8: v8, 9: v9, 10: v10})
    graph = Graph(vertices)
    graph.breath_first_search(1)
    for v in vertices.values():
        v.color = Color.WHITE
    graph.depth_first_search()
    graph.print_vertices()


def topological_sort():
    print('\nTopological Sorted order')
    shirt = Vertex('shirt')
    tie = Vertex('tie')
    jacket = Vertex('jacket')
    belt = Vertex('belt')
    pants = Vertex('pants')
    undershorts = Vertex('undershorts')
    socks = Vertex('socks')
    shoes = Vertex('shoes')
    watch = Vertex('watch')

    shirt.adj_list = [tie, belt]
    tie.adj_list = [jacket]
    belt.adj_list = [jacket]
    pants.adj_list = [belt, shoes]
    undershorts.adj_list = [pants, shoes]
    socks.adj_list = [shoes]

    vertices = dict({'shirt': shirt, 'tie': tie, 'jacket': jacket, 'belt': belt, 'pants': pants,
                    'undershorts': undershorts, 'socks': socks, 'shoes': shoes, 'watch': watch})
    graph = Graph(vertices)
    graph.depth_first_search()
    ordered = graph.topological_sort()
    for v in ordered:
        print(v.key, end=' -> ')
    print('Done')


if __name__ == '__main__':
    __main__()
    topological_sort()
