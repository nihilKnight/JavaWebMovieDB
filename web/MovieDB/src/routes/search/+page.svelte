<script>
  import { onMount } from 'svelte' 
  import { API, KEY } from '../../lib/api'
  import MovieCard from '../../lib/components/MovieCard.svelte'

  let query = ''
  let media = 'movie'
  let page = 1
  let pages = []

  let results

  function changePage(step) {
    page += step
    if (page < 1 || page > 1000) {
      page += -step
      return
    }
    load()
  }

  function selectPage(num) {
    if (num == page) return
    if (num < 1 || num > 1000) return
    page = num
    load()
  }

  function preparePages() {
    let count = page - 5
    let newpages = []
    while (newpages.length < 11) {
      if (count > 0 && count < 1000) {
        newpages.push(count)
      }
      count += 1
    }
    pages = newpages
  }

  async function load() {
    preparePages()
    if (!query || !media) return
    const data = await fetch(
			`${API}/search/${media}${KEY}&page=${page}&language=en-US&query=${query}`
		).then(res => res.json())
    console.log(data)
    results = (data.results)
  }

  onMount(() => load())
</script>


<svelte:head>
	<title>Search - MovieDB</title>
</svelte:head>

<div class="search-container">
  <h2 class="search-title">Search</h2>
  <select name="media" id="media" bind:value={media} on:change={load} class="search-select">
    <option value="movie">Movies</option>
    <option value="person">Person</option>
  </select>
  <form on:submit|preventDefault={load} class="search-form">
    <input type="text" class="search-input" placeholder="Search..." bind:value={query}>
  </form>
</div>

<div class="results-container">
  {#if results}
    <div class="grid-container">
      {#each results as show (show.id)}
        <MovieCard item={show} media={media} />
      {/each}
    </div>
  {:else} 
    <h2 class="waiting-text">Waiting for search...</h2>
  {/if}
</div>

<div class="pagination-container">
  <div class="button-container">
    <button on:click={() => changePage(-1)} class="prev-button">
      Prev
    </button>
    {#each pages as pag (pag)}
    <button on:click={() => selectPage(pag)} class="page-button {pag === page ? 'active-page' : ''}">
      {pag}
    </button>
    {/each}
    <button on:click={() => changePage(1)} class="next-button">
      Next
    </button>
  </div>
</div>

<style>
  .search-container {
  display: flex;
  align-items: center;
  margin-bottom: 1.5rem;
  gap: 1rem;
}

.search-title {
  font-size: 1.5rem;
}

.search-select {
  background-color: #E5E7EB;
  border-radius: 0.25rem;
  padding: 0.25rem 0.5rem;
}

.search-form {
  display: inline-block;
}

.search-input {
  padding: 0.25rem 0.5rem;
  background-color: #E5E7EB;
  outline: none;
  border-radius: 0.25rem;
}

.results-container {
  margin-bottom: 1.5rem;
}

.grid-container {
  display: grid;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  gap: 1rem;
}

@media (min-width: 640px) {
  .grid-container {
    grid-template-columns: repeat(4, minmax(0, 1fr));
  }
}

@media (min-width: 1024px) {
  .grid-container {
    grid-template-columns: repeat(6, minmax(0, 1fr));
  }
}

.waiting-text {
  margin: auto;
  font-size: 1.5rem;
}

.pagination-container {
  display: flex;
  justify-content: center;
  margin-bottom: 1.5rem;
}

.button-container {
  overflow: hidden;
  border-radius: 0.25rem;
  display: flex;
}

.prev-button,
.next-button,
.page-button {
  padding: 0.5rem 1rem;
  background-color: #E5E7EB;
  color: #000000;
  transition: background-color 0.3s, color 0.3s;
}

.prev-button:hover,
.next-button:hover,
.page-button:hover {
  background-color: #D1D5DB;
}

.active-page {
  background-color: #FFD700;
  color: #FFFFFF;
}

</style>