public class Test {
    public static void main(String[] args){

        Pokedex pokedex = new Pokedex();

        Pokemon pikachu = pokedex.createPokemon("pikachu", 20, "Electric");

        Pokemon dugtrio = pokedex.createPokemon("Dugtrio", 50, "Ground");

        System.out.println(pikachu.getHealth());
        pokedex.attackPokemon(pikachu);
        System.out.println( pikachu.getHealth() );

        System.out.println( pokedex.pokemonInfo(pikachu) );

        for ( Object pokemon : pokedex.pokemonInfo(dugtrio) ){  //displays attributes of pokemon on new lines
            System.out.println( pokemon );
        }

        System.out.println(Pokemon.pokeCounter());
    }
}