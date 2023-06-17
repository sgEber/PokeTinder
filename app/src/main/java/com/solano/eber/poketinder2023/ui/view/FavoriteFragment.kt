package com.solano.eber.poketinder2023.ui.view
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.solano.eber.poketinder2023.data.database.entities.MyPokemonEntity
import com.solano.eber.poketinder2023.databinding.FragmentFavoriteBinding
import com.solano.eber.poketinder2023.ui.adapter.MyPokemonsAdapter
import com.solano.eber.poketinder2023.ui.viewmodel.FavoriteViewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate ) {

    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private val listMyPokemon = mutableListOf<MyPokemonEntity>()
    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteViewModel.getMyPokemons(requireContext())
        binding.rvPokemons.adapter = adapter

        favoriteViewModel.myPokemonList.observe( this) {
            listMyPokemon.clear()
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }

        binding.floatingActionDelete.setOnClickListener{
            favoriteViewModel.deleteAllPokemon(requireContext())
        }
    }
}