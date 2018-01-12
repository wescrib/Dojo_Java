import java.util.ArrayList;

public class Pokedex extends Abstract {
    public ArrayList<Object> pokemonInfo(Pokemon pokemon) {
        ArrayList<Object> info = new ArrayList<Object>();
        info.add( pokemon.getName() );
        info.add( pokemon.getHealth() );
        info.add( pokemon.getType() );
        
        return info;
    }
}