# Client-Server-Java

Server: "Knock knock!"
Client: "Who's there?"
Server: "Dexter."
Client: "Dexter who?"
Server: "Dexter halls with boughs of holly."
Client: "Groan."

The example consists of two independently running Java programs: the client program and the server program. The client program is implemented by a single class, KnockKnockClient, and is very similar to the EchoClient example from the previous section. The server program is implemented by two classes: KnockKnockServer and KnockKnockProtocol. KnockKnockServer, which is similar to EchoServer, contains the main method for the server program and performs the work of listening to the port, establishing connections, and reading from and writing to the socket. The class KnockKnockProtocol serves up the jokes. It keeps track of the current joke, the current state (sent knock knock, sent clue, and so on), and returns the various text pieces of the joke depending on the current state. This object implements the protocol—the language that the client and server have agreed to use to communicate.


A basic client-server architecture
