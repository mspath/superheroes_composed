package com.example.androidbasics.superheroes

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasics.superheroes.model.Hero
import com.example.androidbasics.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = 2.dp,
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Composable
fun HeroesList(heroes: List<Hero>, modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(heroes) { hero ->
            HeroItem(hero = hero)
        }
    }
}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroItemPreview() {
    val hero = Hero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    SuperheroesTheme {
        HeroItem(hero = hero)
    }
}

@Preview("Light Theme List")
@Preview("Dark Theme List", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroesListPreview() {
    val hero1 = Hero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    val hero2 = Hero(
        R.string.hero2,
        R.string.description2,
        R.drawable.android_superhero2
    )
    val hero3 = Hero(
        R.string.hero3,
        R.string.description3,
        R.drawable.android_superhero3
    )
    SuperheroesTheme {
        HeroesList(heroes = listOf(hero1, hero2, hero3))
    }
}