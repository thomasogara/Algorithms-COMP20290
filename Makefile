install:
	@ cd src; make all; \
	echo "Installation Complete! To run, simply type \"make run\"";

run:
	@ java -cp out org/algorithms/thomasogara/Main;
	
clean:
	@ rm out -r; \
	echo "clean-up complete! to re-install, simply run \"make install\"";
