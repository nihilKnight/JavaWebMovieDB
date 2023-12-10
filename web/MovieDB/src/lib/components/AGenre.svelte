<script>
  export let props;
  import { onMount } from 'svelte'; 
  import { fade } from 'svelte/transition';

  let isDropdownOpen = false;
  let movieGenres;

  async function load() {
    const data = await fetch(
      `https://api.themoviedb.org/3/genre/movie/list?api_key=799c0bd0b2baaecc6d9301fadfaea7f7&language=en-US`
    ).then(res => res.json());
    movieGenres = data.genres
  }
  function toggleDropdown() {
    isDropdownOpen = !isDropdownOpen;
  }
  onMount(() => load())
</script>

<button 
  on:click={toggleDropdown}
  class="hover:bg-gray-300 dark:hover:bg-gray-700 active:ring-2 
  ring-offset-2 ring-offset-gray-200 dark:ring-offset-gray-800
  ring-blue-500/50 py-1 px-4 rounded-md cursor-pointer"
>
  {props.name}
</button>

{#if isDropdownOpen}
  <div 
  transition:fade={{ duration: 150 }}
    class="py-1 absolute right-10 z-10 mt-2 w-36 origin-top-right rounded-md bg-white shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none" role="menu" aria-orientation="vertical" aria-labelledby="menu-button" tabindex="-1">
    {#each movieGenres as genre}
      <div class="group">
        <a href={`/genre/${genre.id}`} class="text-black block px-4 py-2 text-base font-medium group-hover:text-blue-500/80 truncate overflow-hidden" role="menuitem">
          {genre.name}
        </a>
      </div>
    {/each}
  </div>
{/if}
