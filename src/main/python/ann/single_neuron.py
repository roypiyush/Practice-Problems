# Python program to implement a
# single neuron neural network

from numpy import array, random, dot, tanh


class NeuralNetwork(object):

    def __init__(self):
        # Using seed to make sure it'll generate same weights in every run
        random.seed(1)

        # 3x1 Weight matrix
        self.weight_matrix = 2 * random.random((3, 1)) - 1

    @staticmethod
    def tanh(x):
        """
        tanh as activation fucntion
        :param x:
        :return:
        """
        return tanh(x)

    @staticmethod
    def tanh_derivative(x):
        """
        derivative of tanh function.
        Needed to calculate the gradients.
        :param x:
        :return:
        """
        return 1.0 - tanh(x) ** 2

    def forward_propagation(self, inputs):
        """
        forward propagation
        :param inputs:
        :return:
        """
        dot_product = dot(inputs, self.weight_matrix)
        return self.tanh(dot_product)

    def train(self, train_inputs, train_outputs,
              num_train_iterations):
        """
        training the neural network.
        :param train_inputs:
        :param train_outputs:
        :param num_train_iterations:
        :return:
        """

        # Number of iterations we want to
        # perform for this set of input.
        for iteration in range(num_train_iterations):
            output = self.forward_propagation(train_inputs)

            # Calculate the error in the output.
            error = train_outputs - output

            # multiply the error by input and then
            # by gradient of tanh funtion to calculate
            # the adjustment needs to be made in weights
            adjustment = dot(train_inputs.T, error * self.tanh_derivative(output))

            # Adjust the weight matrix
            self.weight_matrix += adjustment


def main():
    neural_network = NeuralNetwork()
    train_inputs = array([[0, 1, 1], [1, 0, 0], [1, 0, 1], [0, 1, 1]])
    train_outputs = array([[0, 1, 1, 0]]).T
    print('Initial Weights {}'.format(neural_network.weight_matrix.T))

    neural_network.train(train_inputs, train_outputs, 10000)
    print('Final Weights {}'.format(neural_network.weight_matrix.T))

    # Test the neural network with a new situation.
    new_input1 = array([1, 0, 0])
    result = neural_network.forward_propagation(new_input1)
    print("New input1 after training {}, Result {}".format(new_input1, result))

    new_input2 = array([0, 0, 1])
    result = neural_network.forward_propagation(new_input2)
    print("New input2 after training {}, Result {}".format(new_input2, result))

    new_input3 = array([0, 1, 1])
    result = neural_network.forward_propagation(new_input3)
    print("New input3 after training {}, Result {}".format(new_input3, result))


if __name__ == "__main__":
    main()
