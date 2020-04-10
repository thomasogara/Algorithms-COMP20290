install:
	@ cd src; make all; \
	echo "Installation Complete! To run, simply type \"make run\"";

run:
	@ java13 -cp out org/algorithms/thomasogara/Main;
